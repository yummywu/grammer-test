package com.eden.ScheduleJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;
import java.util.Timer;

/**
 * Created by QIAODI on 7/27/2017.
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class HelloJob implements Job {

    public HelloJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello!  HelloJob is executing.");
    }
}
