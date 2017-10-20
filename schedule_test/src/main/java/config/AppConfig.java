/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import task.ScheduledTasks;

/**
 * @author jintao.wang  Date: 17-10-19 Time: 下午8:02
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackageClasses = { ScheduledTasks.class})
public class AppConfig {
}
    