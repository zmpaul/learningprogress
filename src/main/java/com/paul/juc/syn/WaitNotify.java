package com.paul.juc.syn;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2021/9/23 18:17
 */
@Slf4j
public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock){
                log.error(" thread1 name is {}",Thread.currentThread().getName());
                try{
                    Thread.sleep(1);
                    lock.wait();
                    log.error(" thread1 线程被挂起 is {}",Thread.currentThread().getName());
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

        }).start();
        lock.wait();
        new Thread(() -> {
            synchronized (lock){
                log.error(" thread2 name is {}",Thread.currentThread().getName());
                try{
                    Thread.sleep(5000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                lock.notify();
                log.error(" thread2 线程被唤醒 is {}",Thread.currentThread().getName());
            }
        }).start();
    }
}
