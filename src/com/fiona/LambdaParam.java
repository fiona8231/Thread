package com.fiona;

public class LambdaParam {
    public static void main(String[] args) {
       ILove love = null;
       love = a-> System.out.println("I LOVE AC " + a);
       love.love(520);
    }
}

interface ILove{
    void love(int a);
}

