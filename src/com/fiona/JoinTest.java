package com.fiona;

public class JoinTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {

            System.out.println("Vip 线程来了 " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();

        Thread t1 = new Thread(joinTest);


        //主线程
        for (int i = 0; i < 300; i++) {

           if(i==200){
               t1.start();
              t1.join();//插入
           }
            System.out.println("main " + i);
        }
    }
}
