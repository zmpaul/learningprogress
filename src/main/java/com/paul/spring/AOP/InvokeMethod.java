package com.paul.spring.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * private/static/final 方法无法aop
 */
public class InvokeMethod {

    public int add(int a, int b) {
        System.out.println("invoke add ");
        return a + b;
    }

    /**
     * private 方法无法aop
     */
    private int sub(int a, int b) {
        System.out.println("invoke sub ");
        return a - b;
    }

    /**
     * final 方法无法aop
     */
    public final int div(int a, int b) {
        System.out.println("invoke div ");
        return a / b;
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("config/spring/spring-test.xml");
        InvokeMethod bean = ctx.getBean("InvokeMethod", InvokeMethod.class);
        bean.sub(1, 2);
        bean.add(1, 2);
        bean.div(6, 2);
        System.out.println(111);
        ((ConfigurableApplicationContext) ctx).close();
    }
}
