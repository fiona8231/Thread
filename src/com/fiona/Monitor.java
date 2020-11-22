package com.fiona;



//利用缓冲区
public class Monitor {
    public static void main(String[] args) {
        SynchronizationContainer c = new SynchronizationContainer();
        new Product(c).start();
        new Consumer(c).start();
    }
}

//Productor 生产者
class Product extends Thread{
    SynchronizationContainer container;
     public Product(SynchronizationContainer container){
         this.container = container;
     }
     @Override
     public void run(){
         //生产100只鸡
         for (int i = 0; i < 100; i++) {
             System.out.println("生产了 " + i + " chicken");
             try {
                 container.push(new Chicken(i));
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
}
//消费者
class Consumer extends Thread{
    SynchronizationContainer container;
    public Consumer(SynchronizationContainer container){
        this.container = container;
    }
    @Override
    public void run(){

        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费了 -> " + container.pop().id + " chicken");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

//product
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}


//缓冲区
class SynchronizationContainer{
    //容器大小
    Chicken[] container = new Chicken[10];

    //容器计数器
    int count = 0;

    public synchronized void push(Chicken chicken) throws InterruptedException {
        //如果容器满了，就要等待消费者消费
        if(count == container.length){
            //生产等待
            this.wait();

        }
        //如果没有满，我就需要放入产品
        container[count] = chicken;
        count++;
        //可以通知消费者了
        this.notifyAll();

    }

    public synchronized Chicken pop() throws InterruptedException {
        //判断能否消费
        if(count==0){
            //等待生产者生产，消费者等待
            this.wait();
        }
        //如果可以消费
        count--;
        Chicken chicken = container[count];
        //吃完了，通知生产者生产
        this.notifyAll();

        //看吃了那吃鸡
        return chicken;
    }

}