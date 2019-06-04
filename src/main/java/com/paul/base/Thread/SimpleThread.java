package com.paul.base.Thread;

/**
 * 如何保证3个线程顺序执行join的基本用法
 * 
 * @ClassName: SimpleThread
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年5月29日 下午5:01:29
 */
public class SimpleThread {

    public static void main(String[] args) throws InterruptedException {
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        final Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
