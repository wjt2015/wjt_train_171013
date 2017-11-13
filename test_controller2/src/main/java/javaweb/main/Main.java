/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.main;

import java.io.ObjectInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;

import javaweb.enum_test.Color;
import javaweb.enum_test.JdbcType;

/**
 * @author jintao.wang Date: 17-10-18 Time: 下午4:24
 */
public class Main {

    public static void main(String[] args) {
        func2();
    }

    private static void func1() {
        Byte b;
        ObjectInputStream objectInputStream;
        HandlerMapping handlerMapping;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_servlet/spring_servlet.xml");
    }

    private static void func2() {

        int code = JdbcType.BLOB.TYPE_CODE;
        JdbcType jdbcType = JdbcType.ARRAY;
        jdbcType = JdbcType.forCode(code);
        System.out.println("jdbcType=" + jdbcType);
        jdbcType = JdbcType.BINARY;
        int ordinal = jdbcType.ordinal();
        String name = jdbcType.name();
        System.out.println("ordinal = " + ordinal + ";name = " + name);
        /* test Color */
        Color c = Color.RED;
        System.out.println("Before;c=" + c);
        c = Color.BLACK;
        System.out.println("After;c=" + c);
        name = c.name();
        ordinal = c.ordinal();
        System.out.println("ordinal = " + ordinal + ";name = " + name);
        /*
         * SqlSessionFactory sqlSessionFactory; SQL sql; SqlSessionFactoryBuilder sqlSessionFactoryBuilder; Executor
         * executor;
         */
        org.apache.ibatis.type.JdbcType jdbcType1;
    }
}
