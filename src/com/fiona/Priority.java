package com.fiona;

public class Priority {
    public static void main(String[] args) {
        //主线程的默认优先级别 -》 最高
        System.out.println(Thread.currentThread().getName() +
                "=>" + Thread.currentThread().getPriority() );

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);
        //先设置优先级，再启动
        t1.start();
        t2.setPriority(2);
        t2.start();
        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY); //10
        t4.start();

        t5.setPriority(1);
        t5.start();
        t6.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                "=>" + Thread.currentThread().getPriority());
    }
}