package com.Day07.Java8Features;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

    public class PredicateInterfaceDemo {
        public static void main(String[] args) {

            Predicate<Integer> p1=I->I%2==0;
            Predicate<Integer> p2=I->I>20;
            List<Integer> list= Arrays.asList(10,20,30,40,56,55);
            System.out.println("Print all even nos in the list");
            m1(p1,list);
            System.out.println("Print all the nos greater than 20");
            m1(p2,list);
            System.out.println("Print all the elements which are even and greater than 20");
            m1(p1.and(p2),list);
            System.out.println("Print either it is a even or it satifies the condition which is greater than 20");
            m1(p1.or(p2),list);
            System.out.println("Print all odd numbers");
            m1(p1.negate(),list);

        }
        public static void m1(Predicate<Integer> p,List<Integer> list){
            for(int x:list){
                if(p.test(x)){
                    System.out.println(x+" ");
                }
            }
        }

}
