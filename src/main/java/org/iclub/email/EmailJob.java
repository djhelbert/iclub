package org.iclub.email;

public class EmailJob {

    private String password;
    private String toEmail;
    private String subject;
    private String body;
    private String toName;

    public EmailJob() {
    }

    public EmailJob(String password, String toEmail, String subject, String body, String toName) {
        this.body = body;
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
        this.password = password;
        this.toName = toName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
