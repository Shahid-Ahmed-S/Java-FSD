package com.Day06.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list=new ArrayList<>();
        list.add("Shahid");
        list.add(20);
        list.add('M');
        list.add(356.123);
        list.add(true);
        list.add("Shahid");
        list.add(null);
        System.out.println(list);
            list.set(4,false);
            list.add(3,"Sarah");
            System.out.println(list);
            System.out.println(list.get(5));
            list.clear();
            System.out.println(list);
            System.out.println(list.isEmpty());

            Integer[] array=new Integer[]{1,2,3,4,5};
            List<Integer> list1=new ArrayList<>(Arrays.asList(array));
            System.out.println(list1);

            for(int i=0;i<list1.size();i++){
                System.out.println(list1.get(i));
            }
            for(Integer temp:list1){
                System.out.println(temp);
            }
            Iterator<Integer> it=list1.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }

