package com.zhangdong.helloword;

import java.util.Scanner;

public class helloWord {

    public static void main(String[] args) {
        System.out.println("hello word!");
        System.out.println("this is branch dev 0.0.1");
        System.out.println("this is branch dev 0.0.2");

        helloWord hell = new helloWord();
        hell.sayHello();
    }

    public void sayHello(){
        System.out.println("please enter your name:");
        Scanner input=new Scanner(System.in);
        String str=input.next();
        System.out.println("hello, " + str);

        System.out.println("others edit this file, need merge this file!");
    }
}
