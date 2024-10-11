package org.example.LLD.Designs.Scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CleanDiskJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Code to clean disk space goes here
        System.out.println("Cleaning disk space at: " + System.currentTimeMillis());
    }
}
