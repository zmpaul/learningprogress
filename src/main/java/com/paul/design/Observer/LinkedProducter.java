package com.paul.design.Observer;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2021/9/28 11:37
 */
public class LinkedProducter implements Runnable{
    private volatile BlockQueue blockQueue;
    public LinkedProducter(BlockQueue blockQueue){
        this.blockQueue = blockQueue;
    }
    @Override
    public void run() {
        for (int i=0 ;i<5;i++){
            try {
                blockQueue.put(i+"");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
