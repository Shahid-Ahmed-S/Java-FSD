package com.Day06.Collections;
import java.util.*;

    public class HashSetDemo {
        public static void main(String[] args) {
            Set<String> hs=new HashSet<>();
            hs.add("Apple");
            hs.add("Orange");
            hs.add("Banana");
            hs.add("Strawberry");
            System.out.println(hs.size());
            hs.remove("Banana");
            System.out.println(hs);
            Set<String> fruits=new HashSet<>();
            fruits.add("Blueberry");
            fruits.add("Pineapple");
            hs.addAll(fruits);
            System.out.println(hs);

            List<String> list=new ArrayList<>(hs);
            System.out.println(list.get(2));
            for(String temp:hs){
                System.out.println(temp);
            }

            Iterator<String> it=hs.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }



}
