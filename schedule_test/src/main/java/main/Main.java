/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javaweb.task.ScheduledTasks;

/**
 * @author jintao.wang  Date: 17-10-19 Time: 下午8:11
 */
public class Main {
    public static void main(String[] args){
        scheduleTask();
    }

    private static void scheduleTask(){
        String springFile = "spring/springmvc_servlet.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(springFile);
        ScheduledTasks scheduledTasks = ctx.getBean(ScheduledTasks.class);
        System.out.println("\t scheduledTasks = " + scheduledTasks);
    }
}
    