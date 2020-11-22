package com.fiona;

public class Yield {
    public static void main(String[] args) throws InterruptedException {
        MyYeild myYeild = new MyYeild();

        new Thread(myYeild, "a").start();


       new Thread(myYeild, "b").start();
    }
}


class MyYeild implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程开始");

      Thread.yield();
        System.out.println(Thread.currentThread().getName() + " 线程结束");
    }
}