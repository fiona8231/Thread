package com.fiona;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Signal {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(new myThread());
        pool.execute(new myThread());
        pool.execute(new myThread());
        pool.execute(new myThread());
        //关闭连接
        pool.shutdown();
    }
}

class myThread implements Runnable{

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName() );
    }
}