package com.paul.design.Observer;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2021/9/28 13:54
 */
public class LinkedConsumer implements Runnable{
    private volatile BlockQueue blockQueue;
    public LinkedConsumer(BlockQueue blockQueue){
        this.blockQueue = blockQueue;
    }
    @Override
    public void run() {
        for (int i=0 ;i<10;i++){
            try {
                System.out.println("blockQueue take , value :"+blockQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
