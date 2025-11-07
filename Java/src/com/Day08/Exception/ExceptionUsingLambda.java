package com.Day08.Exception;

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread is running: " + Thread.currentThread().getName());
    }
}

public class ExceptionUsingLambda {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
