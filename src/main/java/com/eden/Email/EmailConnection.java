package com.eden.Email;

import javax.mail.Session;
import javax.mail.URLName;
import java.util.Properties;

/**
 * Created by QIAODI on 7/26/2017.
 */
public class EmailConnection {
    private String protocol;
    private String password = null;
    private String folder;
    private String url = null;
    private Properties emailProperties = null;
    private Session session = null;
    private String userAddress = null;
    private String mailserver;
    private String mailboxName;
    private String attachmentFetchSize;

    public EmailConnection(EmailConfig emailConfig) {
        super();

        this.protocol = emailConfig.getMailReceivalProtocol();
        this.mailserver = emailConfig.getMailServer();
        this.mailboxName = emailConfig.getMailBoxName();
        this.password = emailConfig.getMailBoxPasswod();
        this.folder = emailConfig.getDefaultInbox();
        if (emailConfig.getAttachmentFetchSize() != null && !emailConfig.getAttachmentFetchSize().isEmpty())
            this.attachmentFetchSize = emailConfig.getAttachmentFetchSize();
        this.initEmailProperties();
    }


    public java.util.Properties getEmailProperties() {
        return emailProperties;
    }

    public java.lang.String getFolder() {
        return folder;
    }

    public java.lang.String getMailboxName() {
        return mailboxName;
    }

    public java.lang.String getMailserver() {
        return mailserver;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public java.lang.String getProtocol() {
        return protocol;
    }

    public Session getSession() {
        return session;
    }

    public URLName getUrl() {
        URLName urlName = null;
        if (this.url != null) {
            urlName = new URLName(url);
        } else {
            StringBuffer aUrl = new StringBuffer();

            aUrl.append(this.getProtocol());
            aUrl.append("://");
            aUrl.append(this.getMailboxName());
            aUrl.append(":");
            aUrl.append(this.getPassword());
            aUrl.append("@");
            aUrl.append(this.getMailserver());

            urlName = new URLName(aUrl.toString());

            aUrl = null;
        }

        return urlName;
    }

    public java.lang.String getUserAddress() {
        return userAddress;
    }

    private void initEmailProperties() {
        this.emailProperties = System.getProperties();
        this.emailProperties.setProperty("mail.store.protocol", this.protocol);
        this.emailProperties.setProperty("mail.imap.timeout", "300000");// 5 mins
        this.emailProperties.setProperty("mail.imap.connectiontimeout", "600000");// 10 mins

        if (this.attachmentFetchSize != null && !this.attachmentFetchSize.isEmpty()) {
            this.emailProperties.setProperty("mail.imap.fetchsize", this.attachmentFetchSize);
        }

        this.initSession(this.emailProperties);
    }

    private void initSession(Properties aProperties) {
        Properties properties = aProperties;

        if (properties == null) {
            properties = System.getProperties();
        }

        if (this.session == null) {
            this.session = Session.getDefaultInstance(properties, null);
        } else {
            this.session = Session.getInstance(properties, null);
        }

        this.session.setDebug(false);
    }

    public void setEmailProperties(java.util.Properties newEmailProperties) {
        emailProperties = newEmailProperties;

        // Reset session with new properties
        this.initSession(newEmailProperties);
    }

    public void setFolder(java.lang.String newFolder) {
        folder = newFolder;
    }

    public void setMailboxName(java.lang.String newMailboxName) {
        mailboxName = newMailboxName;
    }

    public void setMailserver(java.lang.String newMailserver) {
        mailserver = newMailserver;
    }

    public void setPassword(java.lang.String newPassword) {
        password = newPassword;
    }

    public void setProtocol(java.lang.String newProtocol) {
        protocol = newProtocol;
    }

    public void setUrl(java.lang.String newUrl) {
        url = newUrl;
    }

    public void setUserAddress(java.lang.String newUserAddress) {
        userAddress = newUserAddress;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
