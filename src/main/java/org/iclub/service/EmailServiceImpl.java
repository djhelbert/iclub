package org.iclub.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.iclub.email.EmailJob;
import org.iclub.email.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    private final BlockingQueue<EmailJob> queue = new ArrayBlockingQueue<EmailJob>(1000);
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final String fromEmail;

    public EmailServiceImpl(String from, String fromEmail) {
        this.fromEmail = fromEmail;

        executorService.execute(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        final EmailJob job = queue.take();
                        EmailUtil.sendHtmlEmail(fromEmail, job.getPassword(), from, job.getToEmail(), job.getSubject(), job.getBody(), job.getToName());
                    } catch(InterruptedException e) {
                        LOGGER.error("Email Service", e);
                    }
                }
            }
        });
    }

    @Override
    public String getFromEmail() {
        return fromEmail;
    }

    @Override
    public void addJob(EmailJob job) {
        queue.add(job);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }
}
