package com.paul.base.lock;

public class ExcuteLock {

    private NonReentrantlocks nonReentrantlocks = new NonReentrantlocks();

    public synchronized void excute1() throws InterruptedException {
        nonReentrantlocks.lock();
        excute2();
        nonReentrantlocks.unLock();

    }

    public synchronized void excute2() throws InterruptedException {
        nonReentrantlocks.lock();
        nonReentrantlocks.unLock();
    }

    public synchronized void excute3() throws InterruptedException {
        nonReentrantlocks.synlock();
        excute4();
        nonReentrantlocks.synunLock();

    }

    public synchronized void excute4() throws InterruptedException {
        nonReentrantlocks.synlock();
        nonReentrantlocks.synunLock();
    }

    public static void main(String[] args) throws InterruptedException {
        // new ExcuteLock().excute1();
        new ExcuteLock().excute3();
    }
}
