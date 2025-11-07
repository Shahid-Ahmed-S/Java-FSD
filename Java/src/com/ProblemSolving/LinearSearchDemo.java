package com.ProblemSolving;
public class LinearSearchDemo{
    public static void main(String[] args) {
        int target=75;
        int[] nums={14,23,78,95,75};
        int index=-1;
        long start=System.nanoTime();
        for(int i=0;i<nums.length;i++){//0<5 1<5 2<5 3<5 4<5 5<5
            if(nums[i]==target){//14==75 23==75 78==75 95==75 75==75
                index=i;//4
            }
        }
        long end=System.nanoTime();
        System.out.println("Time Taken: "+((end-start)));
        if(index!=-1){
            System.out.println("Target is found at "+index);
        }
        else{
            System.out.println("Target is not found");
        }
    }
}

