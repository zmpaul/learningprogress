package com.paul.design.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib 代理 AOP的简单实现
 * 原理：cglib动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
 * 
 * @ClassName: DynamicProxyCglib
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年7月23日 下午4:39:35
 */
public class DynamicProxyCglib implements MethodInterceptor {

    private Enhancer en = new Enhancer();
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3)
            throws Throwable {
        System.out.println("before");
        Object object = arg3.invokeSuper(arg0, arg2);
        System.out.println("after");
        return object;
    }

    public Object createProxy(Class classzz) {
        en.setSuperclass(classzz);
        en.setCallback(this);
        return en.create();
    }

    public static void main(String[] args) {
        DynamicProxyCglib cglib = new DynamicProxyCglib();
        Subject realSubject = (Subject) cglib.createProxy(new RealSubjectImpl().getClass());
        realSubject.doSomeThing();
    }

}
