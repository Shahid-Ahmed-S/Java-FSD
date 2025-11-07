package com.Day05.Abstraction;
abstract class Shape{
    String color;
    abstract void draw();
    public void addColor(String color){
        this.color=color;
    }
}
 class Rectangle extends Shape{
    void draw(){
        System.out.println("Drawing Rectangle...");
    }
}
 class Circle extends Shape{
    @Override
    void draw() {
        System.out.println("Drawing Circle...");
    }
}
public class AbstractionDemo {
    public static void main(String[] args) {
        Shape s=new Rectangle();
        s.draw();
    }
}

