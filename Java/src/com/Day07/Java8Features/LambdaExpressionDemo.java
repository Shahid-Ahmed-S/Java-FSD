package com.Day07.Java8Features;
 interface Operation{
        int execute(int a,int b);
    }

    public class LambdaExpressionDemo {
        public static void main(String[] args) {
            Operation add = (a,b) -> a+b;
            System.out.println(add.execute(100,200));

            Operation sub=(a,b)->a-b;
            System.out.println(sub.execute(450,120));

            Operation mul=(a,b)->a*b;
            System.out.println(mul.execute(120,50));

        }

}
