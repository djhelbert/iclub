package org.iclub.service;

import org.iclub.email.EmailJob;

public interface EmailService {

    public void addJob(EmailJob job);
    public void shutdown();
    public Boolean isHealthy();

}
