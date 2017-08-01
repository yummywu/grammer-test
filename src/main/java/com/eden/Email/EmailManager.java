package com.eden.Email;

import javax.mail.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QIAODI on 7/26/2017.
 */
public class EmailManager {
    private EmailConnection connection = null;
    private Store store = null;
    private Folder folder = null;
    private boolean connected = false;
    private boolean backup = false;
    private boolean onlyReadUnseenMessage = false;
    private EmailConfig emailConfig;
    private boolean markOnRead;
    private boolean needGetAttachment = true;

    public EmailManager(EmailConfig emailConfig) {
        super();
        this.emailConfig = emailConfig;
        this.connection = new EmailConnection(emailConfig);
    }

    public void close() throws javax.mail.MessagingException {
        if ((this.folder != null) && (this.folder.isOpen())) {
            this.folder.close(true);
        }

        if (this.store != null) {
            this.store.close();
        }

        this.setConnected(false);
    }

    public void revisedClose() throws MessagingException {
        if (this.folder != null && this.folder.isOpen()) {
            this.folder.close(true);
        }

        if (this.store != null) {
            this.store.close();
        }

        this.setConnected(false);
    }

    public void connect() throws NoSuchProviderException, AuthenticationFailedException, MessagingException, IOException {
        EmailConnection conn = this.getConnection();

        this.openStore(conn);

        this.openFolder(conn.getFolder());

        this.setConnected(true);
    }

    public void connectForRecover() throws NoSuchProviderException, AuthenticationFailedException, MessagingException, IOException {
        EmailConnection conn = this.getConnection();

        this.openStore(conn);

        this.setConnected(true);
    }

    public void connect(EmailConnection aEmailConnection) throws NoSuchProviderException, AuthenticationFailedException,
            MessagingException, IOException {
        this.setConnection(aEmailConnection);
        this.connect();
    }

    public void revisedConnect() throws NoSuchProviderException, AuthenticationFailedException, MessagingException,
            IOException {
        EmailConnection conn = this.getConnection();
        this.openStore(conn);
        this.openFolder(conn.getFolder());
        this.setConnected(true);
    }

    public void bacthDeleteMessages(List<EmailMessage> emailMessages) {
      //todo:
    }

    public void deleteMessage(EmailMessage aEmailMessage) throws MessagingException {
       //TODO:
    }

    private void moveMessage(String folderName, Message message) throws MessagingException {
        Folder destFolder = openFolder(folderName, true);
        this.getFolder().copyMessages(new Message[]{message}, destFolder);
        message.setFlag(Flags.Flag.DELETED, true);
        if (destFolder != null && destFolder.isOpen()) {
            destFolder.close(true);
        }
    }

    private EmailConnection getConnection() {
        return connection;
    }


    public ArrayList<EmailMessage> getEmailMessages() throws MessagingException, IOException {
        return getEmailMessages(this.getFolder());
    }


    public ArrayList<EmailMessage> getEmailMessages(Folder folder) throws MessagingException, IOException {
        if (!this.isConnected()) {
            throw new MessagingException("Email.EmailManager not connected.");
        }
        Message[] messages = folder.getMessages();
        if (messages != null) {
            int msgcount = messages.length;
            ArrayList<EmailMessage> emsgs = new ArrayList<EmailMessage>();

            for (int i = 0; i < msgcount; i++) {
                try {
                    if (!onlyReadUnseenMessage || (onlyReadUnseenMessage && !messages[i].getFlags().contains(Flags.Flag.SEEN))) {
                        EmailMessage emsg = new EmailMessage();
                        emsg.setMessage(messages[i], isNeedGetAttachment());
                        emsgs.add(emsg);
                        if (isMarkOnRead()) {
                            emsg.setMessageAsRead();
                        }
                    }
                } catch (Exception e) {
                    //
                }
            }
            return emsgs;
        }
        return null;
    }



    public javax.mail.Folder getFolder() {
        return folder;
    }

    public javax.mail.Store getStore() {
        return store;
    }

    public boolean isBackupEnabled() {
        return this.backup;
    }

    public boolean isConnected() {
        return this.connected;
    }

    private void openFolder(String folderName) throws MessagingException {
        this.folder = openFolder(folderName, false);
    }

    private Folder openFolder(String folderName, boolean create) throws MessagingException {
        if (folderName == null || (folderName != null && folderName.isEmpty())) {
            throw new MessagingException("Folder name is empty.");
        }
        Folder localFolder = getStore().getFolder(folderName);
        if (!localFolder.exists() && create && !localFolder.create(Folder.READ_WRITE)) {
            throw new MessagingException("Create folder failure.");
        }
        if (!localFolder.exists()) {
            throw new MessagingException("Unable to open email folder [" + folderName + "].");
        }
        if (!localFolder.isOpen()) {
            localFolder.open(Folder.READ_WRITE);
        }

        return localFolder;
    }

    private void openStore(EmailConnection conn) throws NoSuchProviderException, MessagingException {
        String protocol = conn.getProtocol(), host = conn.getMailserver(), user = conn.getMailboxName(), password = conn
                .getPassword();

        Session session = conn.getSession();

        this.store = session.getStore(protocol);
        this.store.connect(host, user, password);
    }

    public void setBackupEnabled(boolean newBackup) {
        this.backup = newBackup;
    }

    private void setConnected(boolean newIsConnected) {
        this.connected = newIsConnected;
    }

    private void setConnection(EmailConnection newConnection) {
        this.connection = newConnection;
    }


    public void setOnlyReadUnseenMessage(boolean onlyreadUnseenMessage) {
        this.onlyReadUnseenMessage = onlyreadUnseenMessage;
    }

    public EmailConfig getEmailConfig() {
        return emailConfig;
    }

    public void setEmailConfig(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    public void setMarkOnRead(boolean markOnRead) {
        this.markOnRead = markOnRead;
    }

    public boolean isMarkOnRead() {
        return markOnRead;
    }

    public void setNeedGetAttachment(boolean needGetAttachment) {
        this.needGetAttachment = needGetAttachment;
    }

    public boolean isNeedGetAttachment() {
        return needGetAttachment;
    }


}
