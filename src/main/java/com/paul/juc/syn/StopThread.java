package com.paul.juc.syn;

import lombok.SneakyThrows;

/**
 * 如何用 interrupt 停止线程，
 * 我们一旦调用某个线程的 interrupt() 之后，这个线程的中断标记位就会被设置成 true。
 * 每个线程都有这样的标记位，当线程执行时，应该定期检查这个标记位，如果标记位被设置成 true，就说明有程序想终止该线程
 * while (!Thread.currentThread().isInterrupted() && more work to do) {
 *     do more work
 * }
 * 通常情况下，我们不会手动停止一个线程，而是允许线程运行到结束，然后让它自然停止。
 * 但是依然会有许多特殊的情况需要我们提前停止线程，比如：用户突然关闭程序，或程序运行出错重启等。
 * 在这种情况下，即将停止的线程在很多业务场景下仍然很有价值。尤其是我们想写一个健壮性很好，
 * 能够安全应对各种场景的程序时，正确停止线程就显得格外重要。但是Java 并没有提供简单易用，能够直接安全停止线程的能力。
 * @author zm
 * @version 1.0
 * @date 2021/9/24 17:21
 */

public class StopThread implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        int count = 0;
        //
        while (!Thread.currentThread().isInterrupted()&&count<1000){
            System.out.println("count = " + count++);
            //throw java.lang.InterruptedException: sleep interrupted
            //Thread.sleep(1000000);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(2);
        thread.interrupt();
    }
}
