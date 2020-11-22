package com.fiona;

public class BuyTicket implements Runnable {

    private int ticket =  20;
    @Override
    public synchronized void run() {
        while (true){
            if(ticket <= 0){
                break;
            }
            else{
                ticket--;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到第 " + ticket+ "票");
        }
    }

    public static void main(String[] args) {
        BuyTicket t1 = new BuyTicket();

        new Thread(t1, "t1").start();
        new Thread(t1,"t2").start();
        new Thread(t1,"t3").start();
    }
}
