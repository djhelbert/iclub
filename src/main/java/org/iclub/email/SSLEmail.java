package org.iclub.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SSLEmail {

    final static String host = "smtp.gmail.com";
    final static String socketFactoryPort = "465";
    final static String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
    final static String auth = "true";
    final static String port = "465";

    public static Session getSession(String fromEmail, String password) {

        final Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", socketFactoryPort);
        props.put("mail.smtp.socketFactory.class", socketFactoryClass);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            // override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        final Session session = Session.getDefaultInstance(props, auth);

        return session;
    }

}
