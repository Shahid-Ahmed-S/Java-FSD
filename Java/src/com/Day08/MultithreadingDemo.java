package com.Day08.Exception;
public class MultithreadingDemo {
    public static void main(String[] args) {
        Runnable r1=()->{
            for(int i=0;i<5;i++){
                System.out.println(i+"->"+"Thread -1");
            }
        };
        Runnable r2=()->{
            for(int i=0;i<5;i++){
                System.out.println(i+"->"+"Thread -2");
            }
        };
        Thread tr1=new Thread(r1);
        Thread tr2=new Thread(r2);
        tr1.start();
        tr2.start();
        try {
            tr1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            tr2.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Last line of main method");
    }
}

