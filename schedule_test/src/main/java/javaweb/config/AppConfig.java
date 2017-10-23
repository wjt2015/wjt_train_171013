/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.config;

import javaweb.task.ScheduledTasks;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author jintao.wang  Date: 17-10-19 Time: 下午8:02
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackageClasses = { ScheduledTasks.class})
public class AppConfig {
}
    