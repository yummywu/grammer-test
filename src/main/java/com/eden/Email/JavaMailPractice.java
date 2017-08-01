package com.eden.Email;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by QIAODI on 7/25/2017.
 */
public class JavaMailPractice {

    public static void main(String[] args) throws Exception {

        EmailConfig emailConfig = new EmailConfig("INBOX", "testhkgowa", "TF04ROOT\\TESTIR4TSA", "Password2", "imap", "16k");
        EmailManager emailManager = new EmailManager(emailConfig);


        synchronized (emailManager) {
            try {
                emailManager.setNeedGetAttachment(false);
                emailManager.setOnlyReadUnseenMessage(true);
                emailManager.setMarkOnRead(false);

                System.out.println("Start to conncect -------------");
                long starTime=System.currentTimeMillis();
                emailManager.connect();
                long connectedTime=System.currentTimeMillis();
                System.out.println("Connected successfully. -------------" + (connectedTime - starTime) / 1000);

                ArrayList<EmailMessage> emailMessages = emailManager.getEmailMessages();
                System.out.println("Unseen email count: " + emailMessages.size() + " Time: " + (System.currentTimeMillis() - starTime) / 1000);
                for (EmailMessage emailMessage : emailMessages) {
                    MimeMessage message = (MimeMessage) emailMessage.getMessage();
                    System.out.println(message.getMessageID());

                    if (message.getSubject().equals("DIANA TEST")) {
                        System.out.println("Get email attachement. -------------");
                        emailMessage.setMessage(message, true);
                        Map<String, Part> attachments = emailMessage.getAttachments();

                        for (Part part : attachments.values()) {
                            System.out.println(part.getSize());
                        }

                    }

                }

            } catch (Throwable e) {
                System.out.println("Get email message exception: " + emailConfig.getMailBoxName() + e);
            } finally {
                try {
                    System.out.println("Close connection. -------------");
                    emailManager.close();
                } catch (MessagingException e) {
                }
            }
        }


    }
}
