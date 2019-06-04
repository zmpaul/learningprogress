package com.paul.base.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.paul.base.lock.ExcuteLock;

public class SimpleScheduleThreadPool {

    /**
     * Callable Runnable 唯一区别Callable有返回
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        Future<String> future = scheduledThreadPoolExecutor.submit(new Callable<String>() {
            public String call() throws Exception {
                // 阻塞型无返回，无阻塞最后返回
                new ExcuteLock().excute3();
                // new ExcuteLock().excute1();
                return "test";
            }

        });
        System.out.println(future.get());

        for (int i = 0; i < 4; i++) {
            scheduledThreadPoolExecutor.schedule(new Runnable() {
                public void run() {
                    try {

                        new ExcuteLock().excute3();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }, 2 * i, TimeUnit.SECONDS);
        }

    }
}
