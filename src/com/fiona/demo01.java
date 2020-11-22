package com.fiona;



public class demo01 extends Thread{
    public void run(){

        for(int i = 0; i < 20; i++){
            System.out.println("我在看代码----"+i);
        }

    }

    public static void main(String[] args) {

        //创建线程对象
        demo01 t1 = new demo01();
        //启动线程
        t1.start();

        for(int i = 0; i < 20; i++){
            System.out.println("我在看玩动森----"+i);
        }

    }
}
