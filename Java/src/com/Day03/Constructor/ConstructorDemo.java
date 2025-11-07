package com.Day04.Constructor;
class Students{
    String name;
    int rno;
    String dept;
    static String college;

    public Students(String name,int rno,String dept,String college){
        this.name=name;
        this.rno=rno;
        this.dept=dept;
        this.college=college;
    }
    public Students(){

    }
    public void display(){
        System.out.println("Name: "+name+"\nRno: "+rno+"\nDept: "+dept+"\nCollege Name: "+college);
    }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Students.college="MSAJCE";
        Students s1=new Students("Shahid",46,"CSE","MSAJCE");
        s1.display();
        System.out.println("----------------------");
        Students s2=new Students();
        s2.name="Reyhan";
        s2.rno=43;
        s2.dept="CSE";
        s2.display();

    }
}

