package com.fiona;


//Runable
public class Runable implements Runnable {
    public void run(){

        for(int i = 0; i < 20; i++){
            System.out.println("我在看代码----"+i);
        }

    }

    public static void main(String[] args) {


        //创建线程对象
        Runable t3 = new Runable();
        //启动线程
        new Thread(t3).start();

        for(int i = 0; i < 20; i++){
            System.out.println("我在看玩动森----"+i);
        }

    }
}
