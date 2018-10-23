package com.paul.design.proxy;

/**
 * 静态代理
 * 
 * @ClassName: StaticProxy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2018年10月8日 下午5:45:17
 */
public class StaticProxy implements Subject {
    private Subject subject;
    public StaticProxy(Subject subject) {
        this.subject = subject;
    }
    public void doSomeThing() {
        System.out.println(" before doSomeThing...");
        subject.doSomeThing();
        System.out.println(" after doSomeThing...");
    }

    public static void main(String[] args) {
        RealSubjectImpl subject = new RealSubjectImpl();
        StaticProxy staticProxy = new StaticProxy(subject);
        staticProxy.doSomeThing();
    }
}

