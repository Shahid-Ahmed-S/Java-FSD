package com.Day06.LeetcodeAssignments;
import java.util.*;

public class IntersectionofTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

            // store all elements from nums1
        for (int n : nums1)
            set1.add(n);

            // check for common elements in nums2
            for (int n : nums2)
                if (set1.contains(n))
                    result.add(n);

            // convert result set to array
            int[] res = new int[result.size()];
            int i = 0;
            for (int n : result)
                res[i++] = n;

            return res;
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            System.out.println(Arrays.toString(intersection(nums1, nums2))); // Output: [2]
        }
    }


