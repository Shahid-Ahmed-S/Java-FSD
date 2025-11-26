package MiniProject03;


import java.util.*;

public class CollectionUtil {

    public static <T> void stackDemo(){
        Stack<T> stack = new Stack<>();
        stack.push((T) "A"); // Example
        stack.push((T) "B");
        System.out.println("Stack: "+stack);
        System.out.println("Pop: "+stack.pop());
    }

    public static <T> void queueDemo(){
        Queue<T> queue = new LinkedList<>();
        queue.add((T)"X"); queue.add((T)"Y");
        System.out.println("Queue: "+queue);
        System.out.println("Poll: "+queue.poll());
    }
}

