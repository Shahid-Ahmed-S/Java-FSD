package com.Day05;
import java.util.*;

public class LeetCodeAssignment {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
            }
            return new int[0];
        }

        public static void main(String[] args) {
            int[] res = twoSum(new int[]{2, -2, 11, 15}, 9);
            System.out.println(Arrays.toString(res));
        }
    }


