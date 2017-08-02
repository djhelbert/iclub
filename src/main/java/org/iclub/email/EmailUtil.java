package org.iclub.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
    private static final String UTF8 = "UTF-8";

    /**
     * Utility method to send simple HTML email
     *
     * @param fromEmail
     * @param password
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(String fromEmail, String password, String name, String toEmail, String subject, String body) {
        try {
            final MimeMessage msg = new MimeMessage(SSLEmail.getSession(fromEmail, password));

            msg.addHeader("Content-Type", "text/html; charset=UTF-8");
            //msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "quoted-printable");
            msg.setFrom(new InternetAddress(fromEmail, name));
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            msg.setSubject(subject, UTF8);
            msg.setText(body, UTF8);
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            Transport.send(msg);
        } catch (Exception e) {
            LOGGER.error("Send Email", e);
        }
    }

    /**
     * Utility method to send email with attachment
     * 
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendAttachmentEmail(Session session, String toEmail, String subject, String body) {
        try {
            final MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@journaldev.com", "NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(body);

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Second part is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "abc.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);
            System.out.println("EMail Sent Successfully with attachment!!");
        } catch (MessagingException e) {
            LOGGER.error("Send Attachment Email", e);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Send Attachment Email", e);
        }
    }
}