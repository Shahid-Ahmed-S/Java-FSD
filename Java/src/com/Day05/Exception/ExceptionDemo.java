package com.Day05.Exception;

public class ExceptionDemo {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 2;
        int[] num = {10, 20, 30, 40, 50};
        String s = "apple";

        try {
            int nums = Integer.parseInt(s); // This will cause NumberFormatException
            System.out.println(nums);
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Happened: " + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index out of bound exception: " + e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println("Number Format Exception: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
        finally {
            System.out.println("Finally block executed.");
        }

        System.out.println("Last line of the program");
    }
}

