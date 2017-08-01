package com.eden.ScheduleJob;

import Email.EmailConfig;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by QIAODI on 7/27/2017.
 */
public class Main {

    public static void main(String[] arg0) throws Exception {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        EmailConfig emailConfig = new EmailConfig("INBOX", "testhkgowa", "TF04ROOT\\TESTIR4TSA", "Password2", "imap", "16k");

        EmailBoxJobInfo jobInfo = new EmailBoxJobInfo("TEST_MAIL", new Date(), new Date(), "SYS", "EMAIL", "RUNNING", 60, 1, emailConfig);
        Map<String, EmailBoxJobInfo> jobInfoMap  = new HashMap<String, EmailBoxJobInfo>();
        jobInfoMap.put(jobInfo.getJobId(), jobInfo);

        JobDataMap jobDataMap = new JobDataMap(jobInfoMap);
        JobDetail job = newJob(EmailBoxJob.class)
                .withIdentity(jobInfo.getJobId(), jobInfo.getJobType()) // name "myJob", group "group1"
                .usingJobData(jobDataMap)
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", jobInfo.getJobType())
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(jobInfo.getIntervalTime())
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        if (!scheduler.isShutdown()) {
            scheduler.start();
        }

    }
}
