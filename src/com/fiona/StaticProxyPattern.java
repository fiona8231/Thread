package com.fiona;

//testing
public class StaticProxyPattern {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱你");
            }
        }).start();

        WeddingCompany company = new WeddingCompany(new Customer());
        company.HappyMarry();
    }
}


interface Marry{
     void HappyMarry(
     );
}

//真是角色
class Customer implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我结婚啦！！！");
    }
}

//代理角色
class WeddingCompany implements Marry{
    private Marry target;


    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        //结婚前
        System.out.println("布置会场");
       this.target.HappyMarry();
        System.out.println("收尾款");
       //结婚后
    }
}