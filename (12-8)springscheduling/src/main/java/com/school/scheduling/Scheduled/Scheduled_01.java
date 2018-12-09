package com.school.scheduling.Scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduled_01 {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private int count = 0;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(cron = "*/6 * * * * ?")
    public void circlePrint() {
        System.out.println("this is scheduler task runing  " + (count++));
    }

    @Scheduled(fixedRate  = 4000)
    public void process() {
        logger.info("定时任务，现在时间："+System.currentTimeMillis());
    }
}
