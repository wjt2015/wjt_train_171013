/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.task;

/**
 * @author jintao.wang  Date: 17-10-19 Time: 下午7:09
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("console--The time is now " + dateFormat.format(new Date()));
        log.info("log--The time is now {}", dateFormat.format(new Date()));
    }
}

    