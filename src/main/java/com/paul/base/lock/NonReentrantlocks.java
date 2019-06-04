package com.paul.base.lock;

/**
 * 重入锁：同一线程可以进入同步块
 * 不可重入锁:同一线程进入获取锁，再次进入同步块。需等待 锁释放
 * 
 * @ClassName: NonReentrantlocks
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年5月13日 下午6:18:58
 */
public class NonReentrantlocks {
    boolean isLock = false;

    /**
     * 模拟锁等待
     */
    public synchronized void lock() throws InterruptedException {
        while (isLock) {
            System.out.println(Thread.currentThread().getName() + "lock 线程等待");
            wait();
        }
        this.isLock = true;
    }

    public synchronized void unLock() throws InterruptedException {
        this.isLock = false;
        System.out.println(Thread.currentThread().getName() + "unLock 线程唤醒");
        notify();
    }

    /**
     * 验证synchronized 为重入锁
     */
    public synchronized void synlock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " synlock 线程锁");
    }

    public synchronized void synunLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " synunLock 线程唤醒");
    }
}
