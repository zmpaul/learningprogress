package com.paul.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Subject subject;

    public DynamicProxy(Subject subject) {
        this.subject = subject;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" before doSomeThing....");
        method.invoke(subject, args);
        System.out.println(" after doSomeThing....");
        return proxy;
    }

    public static void main(String[] args) {
        RealSubjectImpl realSubjectImpl = new RealSubjectImpl();
        InvocationHandler invocationHandler = new DynamicProxy(realSubjectImpl);
        Subject subject =
                (Subject) Proxy.newProxyInstance(realSubjectImpl.getClass().getClassLoader(),
                realSubjectImpl.getClass().getInterfaces(),
                invocationHandler);
        subject.doSomeThing();
    }
}
