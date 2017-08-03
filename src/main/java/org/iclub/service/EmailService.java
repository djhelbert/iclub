package org.iclub.service;

import org.iclub.email.EmailJob;

public interface EmailService {

    public void addJob(EmailJob job);
    public String getFromEmail();
    public void shutdown();

}
