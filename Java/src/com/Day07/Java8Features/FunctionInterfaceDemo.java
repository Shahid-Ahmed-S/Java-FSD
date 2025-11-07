package com.Day07.Java8Features;
import java.util.function.Function;

    public class FunctionInterfaceDemo {
        public static void main(String[] args) {
            Function<String,Integer> f= s->s.length();
            System.out.println(f.apply("Hello World!"));
        }

    }

