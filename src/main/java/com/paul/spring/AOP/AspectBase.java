package com.paul.spring.AOP;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
/**
 * @AfterReturning 方法执行完 aop拦截 .异常向上抛出@AfterThrowing 处理
 *                 Advice:前置、后置、返回、异常、环绕
 *                 pointcut：具体方法
 *                 Aspect：切面
 */
public class AspectBase {

    @AfterReturning(returning = "retVal",
            pointcut = "execution(* com.paul.spring.AOP.InvokeMethod.sub(..))")
    public void subInfo(JoinPoint joinPoint, Object retVal) throws InterruptedException {
        System.out.println("获取目标sub方法返回值:" + retVal);
        try {
            throw new IOException();
        } catch (IOException e) {
            Thread.sleep(2000);
        }
    }

    @Before("execution(* com.paul.spring.AOP.InvokeMethod.add(..))")
    public void addInfoBefore() throws IOException {
        System.out.println("获取目标add before");
        throw new IOException();
    }

    @After("execution(* com.paul.spring.AOP.InvokeMethod.add(..))")
    public void addInfoAfter() {
        System.out.println("获取目标add After");
    }

    @AfterReturning(returning = "retVal",
            pointcut = "execution(* com.paul.spring.AOP.InvokeMethod.add(..))")
    public void addInfo(JoinPoint joinPoint, Object retVal)
 throws InterruptedException {
        System.out.println("获取目标add方法返回值:" + retVal);
        try {
            throw new IOException();
        } catch (IOException e) {
            Thread.sleep(2000);
        }
    }

    @AfterReturning(returning = "retVal",
            pointcut = "execution(* com.paul.spring.AOP.InvokeMethod.div(..))")
    public void divInfo(JoinPoint joinPoint, Object retVal) throws InterruptedException {
        System.out.println("获取目标div方法返回值:" + retVal);
        try {
            throw new IOException();
        } catch (IOException e) {
            Thread.sleep(2000);
        }
    }

    @AfterThrowing(throwing = "ex",
            pointcut = "execution(* com.paul.spring.AOP.InvokeMethod.sub(..))")
    public void doRecoveryActions(Throwable ex) {
        System.out.println("模拟抛出异常后的增强处理...");
    }
}

