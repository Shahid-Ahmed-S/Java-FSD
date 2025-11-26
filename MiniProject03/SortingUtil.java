package MiniProject03;

public class SortingUtil {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j]; arr[j]=arr[j+1]; arr[j+1]=temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int key = arr[i], j=i-1;
            while(j>=0 && arr[j]>key) { arr[j+1]=arr[j]; j--; }
            arr[j+1] = key;
        }
    }

    public static void mergeSort(int[] arr) {
        if(arr.length < 2) return;
        int mid = arr.length/2;
        int[] left = java.util.Arrays.copyOfRange(arr,0,mid);
        int[] right = java.util.Arrays.copyOfRange(arr,mid,arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);
    }
    private static void merge(int[] arr,int[] left,int[] right){
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]) arr[k++]=left[i++];
            else arr[k++]=right[j++];
        }
        while(i<left.length) arr[k++]=left[i++];
        while(j<right.length) arr[k++]=right[j++];
    }

    public static void quickSort(int[] arr) { quickSortHelper(arr,0,arr.length-1);}
    private static void quickSortHelper(int[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSortHelper(arr,low,pi-1);
            quickSortHelper(arr,pi+1,high);
        }
    }
    private static int partition(int[] arr,int low,int high){
        int pivot = arr[high]; int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){ i++; int temp=arr[i]; arr[i]=arr[j]; arr[j]=temp;}
        }
        int temp=arr[i+1]; arr[i+1]=arr[high]; arr[high]=temp;
        return i+1;
    }
}

