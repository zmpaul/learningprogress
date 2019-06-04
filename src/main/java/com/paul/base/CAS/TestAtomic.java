package com.paul.base.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

    private static int insrc = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        extra();
        // insrc : 1991--atomic:2000
        // insrc : 1820--atomic:2000
        System.out.println("insrc : " + insrc + "--atomic:" + atomicInteger.get());

    }

    private static void extra() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // insrc++ 非原子操作
                    insrc++;
                    atomicInteger.getAndIncrement();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    insrc++;
                    atomicInteger.getAndIncrement();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
