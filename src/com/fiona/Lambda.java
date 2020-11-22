package com.fiona;

//推导Lambda
public class Lambda {

    //3.静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("I like lambda static");
        }
    }
    public static void main(String[] args) {
        //创建接口对象
        ILike like = new Like();
        like.lambda();
        like = new Like2();
        like.lambda();

        //4, 局部内部类
         class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("I like lambda 局部类");
            }
        }
         like = new Like3();
         like.lambda();

         //5,匿名内部类 -》借助接口或者父类名实现
        like = new ILike(){
            @Override
            public void lambda() {
                System.out.println("I like lambda 匿名内部类");
            }
        };
        like.lambda();

        //6,lamda,  接口和方法都不要了，因为只有一个
        like = ()->{
            System.out.println("I like lambda λ");
        };
        like.lambda();
    }
}

//1,定义一个函数式接口
interface ILike{
    void lambda();
}

//2,实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}