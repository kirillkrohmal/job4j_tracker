package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class Quartz {
    public static void main(String[] args) throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = newJob(Job.class)
                .withIdentity("job", "group")
                .build();


        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        scheduler.start();

        scheduler.scheduleJob(jobDetail, simpleTrigger);

        scheduler.shutdown();

    }
}
