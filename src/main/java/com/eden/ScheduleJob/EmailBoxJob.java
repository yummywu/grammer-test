package com.eden.ScheduleJob;

import org.quartz.*;

import java.util.Map;

/**
 * Created by QIAODI on 7/27/2017.
 */
public class EmailBoxJob  implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap jobDataMap = context.getMergedJobDataMap();


        Map<String, Object> jobInfoMap = context.getMergedJobDataMap().getWrappedMap();

        for (String jobkey : jobInfoMap.keySet()) {
            System.out.println(jobkey);
        }

    }
}
