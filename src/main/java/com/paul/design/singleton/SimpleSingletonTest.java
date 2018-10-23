package com.paul.design.singleton;

public class SimpleSingletonTest extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
            // System.out.println(Singleton.INSTANCE.getSimpleSingleton().hashCode());
            /*
             * System.out.println(Thread.currentThread().getName() + "---"
             * + SimpleSingleton.getSingleton3().hashCode());
             */
            System.out.println(Thread.currentThread().getName() + "---"
                    + SimpleSingleton.getSingleton().hashCode());
            }
        }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            SimpleSingletonTest myThread = new SimpleSingletonTest();
            myThread.start();
        }
    }
}
