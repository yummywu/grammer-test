package com.eden.Email;

import javax.mail.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by QIAODI on 7/26/2017.
 */
public class EmailMessage {
    private Message message = null;
    private String subject = null;
    private Date sentDate = null;
    private Date receivedDate = null;
    private String lastEmailPartcontentType = null;
    private Map<String, Part> attachments = null;
    private InputStream lastEmailPart = null;
    private boolean deleted = false;
    private Address[] senders;
    private Address[] recepients;

    private static final String SPECIAL_STR_ATTACHMENT_CONTENT_TYPE = "name=";


    public EmailMessage() {
        super();
    }

    public EmailMessage(Message aMessage) throws MessagingException, IOException {
        super();
        this.setMessage(aMessage);
    }

    public void filterAttachmentPart(Part part, List<Part> attachments) throws MessagingException, IOException {
        try {
            if (part != null) {
                Object objContent = part.getContent();
                if (objContent instanceof Multipart) {
                    Multipart multiPart = (Multipart) objContent;
                    int count = multiPart.getCount();
                    for (int i = 0; i < count; i++) {
                        this.filterAttachmentPart(multiPart.getBodyPart(i), attachments);
                    }
                } else if (objContent instanceof Message) {
                    this.filterAttachmentPart((Part) objContent, attachments);
                } else if (part.getContentType() != null && part.getContentType().indexOf(SPECIAL_STR_ATTACHMENT_CONTENT_TYPE) >= 0) {
                    attachments.add(part);
                }
            }
        } catch (Exception ex) {
            System.out.println("filterAttachmentPart" +  "error when filter email attachment" + ex);
        }
    }


    public java.lang.String getLastEmailPartcontentType() {
        return lastEmailPartcontentType;
    }

    public Message getMessage() {
        return message;
    }

    public InputStream getLastEmailPart() {
        return lastEmailPart;
    }

    public java.util.Date getReceivedDate() {
        return receivedDate;
    }

    public java.util.Date getSentDate() {
        return sentDate;
    }

    public java.lang.String getSubject() {
        return subject;
    }

    public boolean isDeleted() {
        return deleted;
    }

    private void setLastEmailPartcontentType(java.lang.String newContentType) {
        lastEmailPartcontentType = newContentType;
    }

    public void setDeleted(boolean newDeleted) throws MessagingException {
        this.getMessage().setFlag(Flags.Flag.DELETED, newDeleted);

        deleted = newDeleted;
    }

    public void setMessage(javax.mail.Message newMessage, boolean needGetAttachment) throws MessagingException, IOException {
        message = newMessage;
        if (newMessage != null) {
            // this.setSubject(MimeUtility.decodeText(newMessage.getHeader("subject")[0]));
            this.setSubject(newMessage.getHeader("subject")[0]);
            this.setSentDate(newMessage.getSentDate());
            this.setReceivedDate(newMessage.getReceivedDate());
            this.setSenders(newMessage.getFrom());
            // set attachments
            if (needGetAttachment) {
                List<Part> msgparts = new ArrayList<Part>();
                this.filterAttachmentPart(newMessage, msgparts);
                if (msgparts != null && !msgparts.isEmpty()) {
                    this.setMsgpart(msgparts.get(msgparts.size() - 1));
                    attachments = new HashMap<String, Part>();
                    int attachmentSequence = 0;
                    for (Part thisPart : msgparts) {
                        attachments.put(thisPart.getContentType() + " attachment sequence=" + attachmentSequence, thisPart);
                        attachmentSequence++;
                    }
                }
            }
        }
    }

    public void setMessage(javax.mail.Message newMessage) throws MessagingException, IOException {
        setMessage(newMessage, true);
    }

    private void setLastEmailPart(java.io.InputStream newMessageBody) {
        lastEmailPart = newMessageBody;
    }

    private void setMsgpart(javax.mail.Part newMsgpart)
            throws MessagingException, IOException {
        if (newMsgpart != null) {
            this.setLastEmailPartcontentType(newMsgpart.getContentType());
            this.setLastEmailPart(newMsgpart.getInputStream());
        }
    }

    private void setReceivedDate(java.util.Date newReceivedDate) {
        receivedDate = newReceivedDate;
    }

    private void setSentDate(java.util.Date newSentDate) {
        sentDate = newSentDate;
    }

    private void setSubject(java.lang.String newSubject) {
        subject = newSubject;
    }

    public Map<String, Part> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, Part> attachments) {
        this.attachments = attachments;
    }

    public Address[] getSenders() {
        return senders;
    }

    public void setSenders(Address[] senders) {
        this.senders = senders;
    }

    public Address[] getRecepients() {
        return recepients;
    }

    public void setRecepients(Address[] recepients) {
        this.recepients = recepients;
    }

    public void setMessageAsRead() throws MessagingException {
        message.setFlag(Flags.Flag.SEEN, true);
    }

    public static String getEmailTextContext(Part part) throws IOException, MessagingException {
        Object objContent = part.getContent();
        if (objContent instanceof String) {
            return objContent.toString();
        } else if (objContent instanceof Message) {
            return getEmailTextContext((Part) objContent);
        }
        else if (objContent instanceof Multipart) {
            StringBuffer sb = new StringBuffer();
            Multipart multiPart = (Multipart) objContent;
            int count = multiPart.getCount();
            for (int i = 0; i < count; i++) {
                sb.append(getEmailTextContext(multiPart.getBodyPart(i))).append(System.getProperty("line.separator"));
            }
            return  sb.toString();
        }
        return "";
    }

    public boolean filterMessage(Part part, Vector<Part> partList) throws MessagingException, IOException {
        Object objContent = null;
        Vector<Part> aList = partList;

        if (part != null) {
            aList.add(part);

            objContent = part.getContent();

            if (objContent instanceof String) {
                return true;
            } else if (objContent instanceof Multipart) {
                Multipart multiPart = (Multipart) objContent;

                int count = multiPart.getCount();
                for (int i = 0; i < count; i++) {
                    this.filterMessage(multiPart.getBodyPart(i), aList);
                }

                return true;
            } else if (objContent instanceof Message) {
                return this.filterMessage((Part) objContent, aList);
            } else if (objContent instanceof InputStream) {
                return true;
            } else {
                System.out.println("Email.EmailMessage.filterMessage: Warning. Could not determine instance type of Message Part. Part is a "
                        + objContent.getClass().getName() + " class.");
            }
        } else {
            System.out.println("Email.EmailMessage.filterMessage: Warning. Message Part is NULL.");
        }

        return false;
    }

    public static Message[] extractMessages(List<EmailMessage> emailMessages) {
        int length = emailMessages != null ? emailMessages.size() : 0;
        if (length > 0) {
            Message[] messages = new Message[length];
            for (int i = 0; i < length; i++) {
                messages[i] = emailMessages.get(i).getMessage();
            }
            return messages;
        }
        return null;
    }

}
