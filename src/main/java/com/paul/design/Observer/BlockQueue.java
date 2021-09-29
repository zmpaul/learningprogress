package com.paul.design.Observer;
import java.util.LinkedList;

/**
 *
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2021/9/28 10:55
 */
public class BlockQueue {
    private int maxSize;
    private LinkedList<String> queue;
    public BlockQueue( int maxSize){
        queue = new LinkedList<>();
        this.maxSize = maxSize;
    }
    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element becomes available.
     *
     * @return the head of this queue
     * @throws InterruptedException if interrupted while waiting
     */
    public synchronized  String take() throws InterruptedException {
        while (queue.size()==0){
            this.wait();
        }
        this.notifyAll();
        return queue.remove();
    }
    /**
     * Inserts the specified element into this queue, waiting if necessary
     * for space to become available.
     *
     * @param e the element to add
     * @throws InterruptedException if interrupted while waiting
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this queue
     */
    public synchronized void put(String content) throws InterruptedException {
        while (queue.size()==maxSize){
            this.wait();
        }
        System.out.println(" blockQueue put ,value : "+content);
        queue.add(content);
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueue blockQueue = new BlockQueue(2);
        Thread product = new Thread(new LinkedProducter(blockQueue));
        product.start();
        Thread.sleep(1000);
        Thread consumer = new Thread(new LinkedConsumer(blockQueue));
        consumer.start();
    }
}
