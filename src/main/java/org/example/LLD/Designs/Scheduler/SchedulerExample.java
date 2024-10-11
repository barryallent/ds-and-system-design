package org.example.LLD.Designs.Scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerExample {

    public static void main(String[] args) throws SchedulerException {

        // Define the email job and tie it to the EmailJob class
        JobDetail emailJob = JobBuilder.newJob(EmailJob.class)
                .withIdentity("emailJob", "group1")
                .build();

        // Define the trigger for the email job (every Monday at 10:00 AM)
        Trigger emailTrigger = TriggerBuilder.newTrigger()
                .withIdentity("emailTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 10 ? * MON"))
                .build();


        // Define the disk clean-up job and tie it to the CleanDiskJob class
        JobDetail cleanDiskJob = JobBuilder.newJob(CleanDiskJob.class)
                .withIdentity("cleanDiskJob", "group2")
                .build();

        // Define the trigger for the disk clean-up job (every day at 7:00 AM)
        Trigger cleanDiskTrigger = TriggerBuilder.newTrigger()
                .withIdentity("cleanDiskTrigger", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
                .build();


        // Create a Scheduler instance
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // Start the scheduler
        scheduler.start();

        // Schedule the email job and clean-up job
        scheduler.scheduleJob(emailJob, emailTrigger);
        scheduler.scheduleJob(cleanDiskJob, cleanDiskTrigger);
        System.out.println("App is up");
    }
}

