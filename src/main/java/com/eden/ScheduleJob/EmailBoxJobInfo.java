package com.eden.ScheduleJob;

import Email.EmailConfig;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.PersistJobDataAfterExecution;

import java.util.Date;

/**
 * Created by QIAODI on 7/27/2017.
 */


public class EmailBoxJobInfo {
    private String jobId;
    private Date jobCreateTime;
    private Date jobLastUpdateTime;
    private String JobCreator;
    private String jobType;
    private String status;
    private Integer intervalTime;
    private int priority;
    private EmailConfig emailConfig; // Email box configure

    public EmailBoxJobInfo(String jobId, Date jobCreateTime, Date jobLastUpdateTime, String jobCreator, String jobType, String status, Integer intervalTime, int priority, EmailConfig emailConfig) {
        this.jobId = jobId;
        this.jobCreateTime = jobCreateTime;
        this.jobLastUpdateTime = jobLastUpdateTime;
        JobCreator = jobCreator;
        this.jobType = jobType;
        this.status = status;
        this.intervalTime = intervalTime;
        this.priority = priority;
        this.emailConfig = emailConfig;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Date getJobCreateTime() {
        return jobCreateTime;
    }

    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    public Date getJobLastUpdateTime() {
        return jobLastUpdateTime;
    }

    public void setJobLastUpdateTime(Date jobLastUpdateTime) {
        this.jobLastUpdateTime = jobLastUpdateTime;
    }

    public String getJobCreator() {
        return JobCreator;
    }

    public void setJobCreator(String jobCreator) {
        JobCreator = jobCreator;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public EmailConfig getEmailConfig() {
        return emailConfig;
    }

    public void setEmailConfig(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }
}
