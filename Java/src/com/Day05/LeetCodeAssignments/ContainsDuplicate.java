package com.Day05.LeetCodeAssignments;
import java.util.*;
public class ContainsDuplicate {
        public static boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                if (!set.add(n))  // add() returns false if element already exists
                    return true;
            }
            return false;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 1};
            System.out.println(containsDuplicate(nums));  // Output: true

            int[] nums2 = {1, 2, 3, 4};
            System.out.println(containsDuplicate(nums2)); // Output: false
        }
    }


