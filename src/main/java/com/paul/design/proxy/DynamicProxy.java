package com.paul.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理实现，必须实现InvocationHandler接口 AOP的简单实现
 * 原理：java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
 * 
 * @ClassName: DynamicProxy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年7月23日 下午3:27:34
 */
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

    public static Object createProxy(Class classzz, InvocationHandler invocationHandler) {
        Object object = Proxy.newProxyInstance(classzz.getClassLoader(), classzz.getInterfaces(),
                invocationHandler);
        return object;
    }

    public static void main(String[] args) {
        RealSubjectImpl realSubjectImpl = new RealSubjectImpl();
        InvocationHandler invocationHandler = new DynamicProxy(realSubjectImpl);
        Subject subject = (Subject)createProxy(realSubjectImpl.getClass(), invocationHandler);
        subject.doSomeThing();
    }
}
