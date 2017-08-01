package com.eden.Email;

import java.io.Serializable;

/**
 * Created by QIAODI on 7/26/2017.
 */
public class EmailConfig implements Serializable {
    private static final long serialVersionUID = 489715432512245L;
    String defaultInbox;
    String mailServer;
    String mailBoxName;
    String mailBoxPasswod;
    String mailReceivalProtocol;
    String attachmentFetchSize;
    private String type;
    private String defaultHousekeepExpression = "* * * 16 0";//pattern is month day_of_month day_of_week hour minute
    private String housekeepExpression;//pattern is month day_of_month day_of_week hour minute
    private boolean housekeepOnly;

    public EmailConfig(String defaultInbox, String mailServer, String mailBoxName, String mailBoxPasswod, String mailReceivalProtocol, String attachmentFetchSize) {
        this.defaultInbox = defaultInbox;
        this.mailServer = mailServer;
        this.mailBoxName = mailBoxName;
        this.mailBoxPasswod = mailBoxPasswod;
        this.mailReceivalProtocol = mailReceivalProtocol;
        this.attachmentFetchSize = attachmentFetchSize;
    }

    public boolean isHousekeepOnly() {
        return housekeepOnly;
    }

    public void setHousekeepOnly(boolean housekeepOnly) {
        this.housekeepOnly = housekeepOnly;
    }

    public String getHousekeepExpression() {
        return housekeepExpression;
    }

    public void setHousekeepExpression(String housekeepExpression) {
        this.housekeepExpression = housekeepExpression;
    }

    public String getDefaultHousekeepExpression() {
        return defaultHousekeepExpression;
    }

    public String getDefaultInbox() {
        return defaultInbox;
    }

    public void setDefaultInbox(String defaultInbox) {
        this.defaultInbox = defaultInbox;
    }

    public String getMailBoxName() {
        return mailBoxName;
    }

    public void setMailBoxName(String mailBoxName) {
        this.mailBoxName = mailBoxName;
    }

    public String getMailBoxPasswod() {
        return mailBoxPasswod;
    }

    public void setMailBoxPasswod(String mailBoxPasswod) {
        this.mailBoxPasswod = mailBoxPasswod;
    }

    public String getMailServer() {
        return mailServer;
    }

    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }

    public String getMailReceivalProtocol() {
        return mailReceivalProtocol;
    }

    public void setMailReceivalProtocol(String mailReceivalProtocol) {
        this.mailReceivalProtocol = mailReceivalProtocol;
    }

    @Override
    public String toString() {
        return "Email.EmailConfig{" + "defaultInbox='" + defaultInbox + "'" + ", defaultBackupInBox='" + "mailServer='" + mailServer + "'" + ", mailBoxName='" + mailBoxName + "'"
                + ", mailBoxPasswod='" + mailBoxPasswod + "'" + ", mailReceivalProtocol='" + mailReceivalProtocol + "'"
                + ", attachmentFetchSize='" + attachmentFetchSize + "'" + "}";
    }

    public String getAttachmentFetchSize() {
        return attachmentFetchSize;
    }

    public void setAttachmentFetchSize(String attachmentFetchSize) {
        this.attachmentFetchSize = attachmentFetchSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
