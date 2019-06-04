package com.paul.base.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.paul.base.lock.ExcuteLock;

/**
 * 线程池创建线程需要获取mainlock这个全局锁，影响并发效率，阻塞队列可以很好的缓冲。
 * 如果新任务的到达速率超过了线程池的处理速率，那么新到来的请求将累加起来，这样的话将耗尽资源。
 * 
 * @ClassName: SimpleThreadPool
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年5月16日 下午3:08:25
 */
public class SimpleThreadPool extends Thread {

    public static ThreadPoolExecutor threadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor threadPool2() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 60, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        return threadPoolExecutor;
    }

    public static void main(String[] args) throws InterruptedException {
        // new SimpleThreadPool().start();
        new SimpleThreadPool().start();
    }

    private static void executer(final ThreadPoolExecutor poolExecutor,
            final BlockingQueue arrayBlockingQueue) {
        for (int i = 0; i < 20; i++) {
            poolExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(arrayBlockingQueue);
                        System.out.println("================");
                        System.out.println("CorePoolSize : " + poolExecutor.getCorePoolSize());
                        System.out.println("PoolSize:" + poolExecutor.getPoolSize());
                        System.out.println("TaskCount:" + poolExecutor.getTaskCount());
                        System.out.println(
                                "CompletedTaskCount:" + poolExecutor.getCompletedTaskCount());
                        System.out.println("LargestPoolSize:" + poolExecutor.getLargestPoolSize());
                        System.out.println("ActiveCount:" + poolExecutor.getActiveCount());
                        System.out.println("================");
                        new ExcuteLock().excute3();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void run() {
        // TODO Auto-generated method stub
        final ThreadPoolExecutor poolExecutor = SimpleThreadPool.threadPool();
        final ArrayBlockingQueue arrayBlockingQueue = (ArrayBlockingQueue) poolExecutor.getQueue();

        final ThreadPoolExecutor poolExecutor2 = SimpleThreadPool.threadPool();
        final ArrayBlockingQueue arrayBlockingQueue2 =
                (ArrayBlockingQueue) poolExecutor2.getQueue();

        executer(poolExecutor, arrayBlockingQueue);
        // executer(poolExecutor2, arrayBlockingQueue2);
    }
}
