package com.paul.juc.syn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * volatile:
 *      volatile，即易变的，在Java中标识一个变量是易变变量。
 *      volatile可以看成轻量级的synchronized，相对于synchronized：编码简单、资源开销较少，同样的实现的功能也有限。
 *      volatile能够保证变量的可见性，但是并不能保证变量的原子性和有序性。
 *      使用volatile的前提，不受原子性和有序性影响：变量状态完全独立于任何程序的其他状态。
 * 使用一次性状态标志的关键点:
 *      1.状态标志的状态转换是原子操作。例如上面的代码中，对布尔类型进行赋值操作，在Java中是原子性操作。
 *      2.只有一次性的状态转换。上面的代码中，状态标志位只是从false转换为true，并没有继续进行从true到false的转换等。这种转换的一次性杜绝了有序性问题的产生。
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 10:00
 */
public class VolatileCanNotStop {
    class Producer implements Runnable {
        public volatile boolean canceled = false;
        BlockingQueue storage;
        public Producer(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 100000 && !canceled) {
                    if (num % 50 == 0) {
                        storage.put(num);
                        System.out.println(num + "是50的倍数,被放到仓库中了。");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者结束运行");
            }
        }
    }
    class Consumer {
        BlockingQueue storage;
        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }
        public boolean needMoreNums() {
            if (Math.random() > 0.97) {
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(8);

        Producer producer = new VolatileCanNotStop().new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(500);
        VolatileCanNotStop.Consumer consumer = new VolatileCanNotStop().new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了。");

        //一旦消费不需要更多数据了，我们应该让生产者也停下来，但是实际情况却停不下来
        /*
            生产者在执行 storage.put(num) 时发生阻塞，在它被叫醒之前是没有办法进入下一次循环判断 canceled 的值的，
            所以在这种情况下用 volatile 是没有办法让生产者停下来的，相反如果用 interrupt 语句来中断，即使生产者处于阻塞状态，
            仍然能够感受到中断信号，并做响应处理。
         **/
        producer.canceled = true;
        //producerThread.interrupt();
    }
}