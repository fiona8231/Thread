package com.fiona;

import java.util.concurrent.locks.ReentrantLock;

public class Lock2 implements Runnable{
    public static void main(String[] args) {
        Lock2 t = new Lock2();

        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }

    int tickNum = 10;
    //定义reentrantlock
    private final ReentrantLock reentrantlock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            reentrantlock.lock();
            try{
                if(tickNum > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println( tickNum--);
                }else {
                    break;
                }

            }finally {
                  //解决
                reentrantlock.unlock();
            }



        }
    }
}
