package com.fiona;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("///////");
            }
        });
        //观察状态
        Thread.State state = t.getState();
        System.out.println(state);

        //观察启动后
        t.start();
        state = t.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = t.getState();//更新线程转态
            System.out.println(state);
        }

        t.start();
    }
}
