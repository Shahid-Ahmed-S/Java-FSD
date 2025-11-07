package com.ProblemSolving;
import java.util.*;

public class ArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements for an array (comma-separated):");

        // Read the whole line as text
        String input = sc.nextLine();

        // Split using commas and remove extra spaces
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.println("Array elements are:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
