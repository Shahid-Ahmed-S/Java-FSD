package com.Day06.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

    public class HashMapDemo {
        public static void main(String[] args) {
            Map<Integer,String> hm=new HashMap<>();
            hm.put(101,"Apple");
            hm.put(102,"Strawberry");
            hm.put(103,"Pineapple");
            hm.put(104,"Orange");
            System.out.println(hm.size());
            hm.remove(102);
            System.out.println(hm.get(104));
            System.out.println(hm.keySet());
            System.out.println(hm.values());
            System.out.println(hm.entrySet());
            for(int key:hm.keySet()){
                System.out.println(key+"->"+hm.get(key));
            }
            Iterator<Map.Entry<Integer,String>> it=hm.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer,String> pair=it.next();
                System.out.println(pair.getKey()+"->"+pair.getValue());
            }
        }

}
