package org.example.LLD.Designs.Scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EmailJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Code to send an email goes here
        System.out.println("Sending email at: " + System.currentTimeMillis());
    }
}

