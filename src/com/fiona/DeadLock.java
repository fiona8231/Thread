package com.fiona;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑凉");
        Makeup g2 = new Makeup(1, "白雪公主");
        g1.start();
        g2.start();
    }
}

class Lipstick{
}

class Mirror{
}

class Makeup extends Thread {
    //需要的资源只有一份，用static来保证只有一份
    static Lipstick lp = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lp) {
                System.out.println(this.girlName + " 获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");  //过了1秒后，她想拿到镜子的锁
            }
        } else {
            //第二个人抱着镜子想要口红的锁
            synchronized (mirror) {
                System.out.println(this.girlName + " 获得镜子的锁");
                Thread.sleep(2000);
            }
             synchronized (lp) {
                System.out.println(this.girlName + "获得口红的锁");  //过了2秒后，她想拿到口红的锁
            }
        }
    }
}