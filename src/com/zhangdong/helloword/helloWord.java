package com.zhangdong.helloword;

public class helloWord {

    public static void main(String[] args) {
        System.out.println("hello word!");
        System.out.println("this is branch dev 0.0.1");
        System.out.println(sum(1,2));
    }

    public static int sum(int a, int b){
        if(a<0)
            a=0;
        return a+b;
    }
}
