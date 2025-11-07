package com.Day04.Inheritance;

class GrandFather{
    public void land(){
        System.out.println("10 Acres of Land....");
        }
    }
    class Father extends GrandFather{
        public void house(){
            System.out.println("3BHK House....");
        }
    }
    class Son extends Father{
        public void car(){
            System.out.println("7 Seater Car...");
        }
    }
    class Daughter extends Father{
        public void house2(){
            System.out.println("Owned another big house...");
        }
    }

public class InheritanceDemo {
        public static void main(String[] args) {
            Father father=new Father();
            father.house();
            System.out.println("---------------------------");
            Son son=new Son();
            son.car();
            son.house();
        }
    }

