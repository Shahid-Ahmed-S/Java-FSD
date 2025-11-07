package com.Day08;
    class Thread1 implements Runnable{
        public synchronized void run(){
            for(int i=0;i<10;i++){
                System.out.println(i+"->"+Thread.currentThread().getName());
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public class SynchronizedKeyword {
        public static void main(String[] args) {
            Thread1 t=new Thread1();
            Thread t1=new Thread(t);
            Thread t2=new Thread(t);
            Thread t3=new Thread(t);
            t1.start();
            t2.start();
            t3.start();
        }
    }

