/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;

import java.io.ObjectInputStream;

/**
 * @author jintao.wang  Date: 17-10-18 Time: 下午4:24
 */
public class Main {
    public static void main(String[] args){
        Byte b;
        ObjectInputStream objectInputStream;
        HandlerMapping handlerMapping;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_servlet/spring_servlet.xml");

    }
}
    