package com.paul.design.singleton;

import org.apache.log4j.Logger;

/**
 * 单例模式 只允许提供一个实例 且 对外提供唯一实例
 */
public class SimpleSingleton {

    private static Logger logger = Logger.getLogger(SimpleSingleton.class);

    private SimpleSingleton() {

    }

    private static SimpleSingleton simpleSingleton = null;

    // case 1 多线程 线程安全 延迟加载
    public static SimpleSingleton getSingleton() {
        synchronized (SimpleSingleton.class) {
            if (simpleSingleton == null) {
                simpleSingleton = new SimpleSingleton();
            }
        }
        return simpleSingleton;
    }

    /**
     * 多线程安全：是
     * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
     */
    public static synchronized SimpleSingleton getSingleton2() {
        if (simpleSingleton == null) {
            System.out.println("into 线程安全 同步锁");
            simpleSingleton = new SimpleSingleton();
        }
        return simpleSingleton;
    }

    // case 2 非线程安全 延迟加载
    /**
     * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
     * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
     */
    public static SimpleSingleton getSingleton3() {
        if (simpleSingleton == null) {
            System.out.println("into");
            if (simpleSingleton == null) {
                simpleSingleton = new SimpleSingleton();
            }
        }
        return simpleSingleton;
    }

    // 线程安全 饿汉式
    /**
     * 描述：这种方式比较常用，但容易产生垃圾对象。
     * 优点：没有加锁，执行效率会提高。
     * 缺点：类加载时就初始化，浪费内存。
     * 它基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance
     * 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
     */
    private static SimpleSingleton simpleSingleton2 = new SimpleSingleton();
    public static SimpleSingleton getSingleton4() {
        if (simpleSingleton2 == null) {
            System.out.println("into 线程安全 饿汉模式");
            simpleSingleton2 = new SimpleSingleton();
        }
        return simpleSingleton2;
    }

    // DCL 双重检查锁 线程安全
    private static volatile SimpleSingleton simpleSingleton3;

    /**
     * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能
     * volatile 保证原子可见性 避免指令重排序
     */
    public static SimpleSingleton getSingleton5() {
        if (simpleSingleton3 == null) {
            synchronized (SimpleSingleton.class) {
                if (simpleSingleton3 == null) {
                    // volatile 保证原子可见性 避免指令重排序 没有同步主内存区 ，下一线程获取simpleSingleton3 = null 导致多个实例
                    simpleSingleton3 = new SimpleSingleton();
                }
            }
        }
        return simpleSingleton3;
    }

    // 静态内部类
    /**
     * 这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-
     * Loading的作用，而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，
     * 从而完成Singleton的实例化。
     * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
     * 优点：避免了线程不安全，延迟加载，效率高。
     */
    private static class SingletonInstance
    {

        private final static SimpleSingleton INSTANCE = new SimpleSingleton();
    }

    public static SimpleSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 使用enum枚举数据类型实现
     * Singleton.INSTANCE.getSimpleSingleton 获取实例
     */
    public enum Singleton {
        INSTANCE;

        private SimpleSingleton simpleSingleton;
        private Singleton() {
            logger.info("into");
            simpleSingleton = new SimpleSingleton();
        }

        public SimpleSingleton getSimpleSingleton() {
            return simpleSingleton;
        }
    }
}
