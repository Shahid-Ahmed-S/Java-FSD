package MiniProject03;

import java.util.Arrays;

public class TestAlgorithmToolkit {
    public static void main(String[] args) {
        int[] arr = {5,2,9,1,5,6};

        System.out.println("Original Array: "+ Arrays.toString(arr));

        int[] bubbleArr = arr.clone();
        AnalysisUtil.benchmark(()->SortingUtil.bubbleSort(bubbleArr));
        System.out.println("Bubble Sorted: "+Arrays.toString(bubbleArr));

        int[] insertArr = arr.clone();
        AnalysisUtil.benchmark(()->SortingUtil.insertionSort(insertArr));
        System.out.println("Insertion Sorted: "+Arrays.toString(insertArr));

        int[] mergeArr = arr.clone();
        AnalysisUtil.benchmark(()->SortingUtil.mergeSort(mergeArr));
        System.out.println("Merge Sorted: "+Arrays.toString(mergeArr));

        int[] quickArr = arr.clone();
        AnalysisUtil.benchmark(()->SortingUtil.quickSort(quickArr));
        System.out.println("Quick Sorted: "+Arrays.toString(quickArr));

        System.out.println("Linear Search for 5: "+SearchUtil.linearSearch(arr,5));
        int[] sortedArr = arr.clone(); SortingUtil.quickSort(sortedArr);
        System.out.println("Binary Search for 5: "+SearchUtil.binarySearch(sortedArr,5));

        CollectionUtil.stackDemo();
        CollectionUtil.queueDemo();
    }
}

