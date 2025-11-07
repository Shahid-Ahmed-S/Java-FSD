package com.Day03.MethodsandTypes;

public class MathUtility {

    public static void main(String[] args) {
        MathUtility obj=new MathUtility();
        obj.add();
        sub(10,20);

        System.out.println(mul());
        System.out.println(div(5,2));
    }

    public void add(){
        int num1=10;
        int num2=20;
        int sum=num1+num2;
        System.out.println(sum);
    }

    public static void sub(int num1,int num2){
        int sub=Math.abs(num1-num2);
        System.out.println(sub);
    }
    public static double mul(){
        int num1=15;
        int num2=25;
        double result=num1*num2;
        return result;
    }
    public static double div(int num1,int num2){
        double div=(float)num1/num2;
        return div;
    }
}

