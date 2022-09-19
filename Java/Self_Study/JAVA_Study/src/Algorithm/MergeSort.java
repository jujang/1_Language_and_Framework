package Algorithm;

public class MergeSort {
    public static void main(String[] args){

//        int[] arr = {5, 7, 1, 4, 3};
        int[] arr = {1, -5, 10, 88, 3, 1010, 999, 50};

        mergeSort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void mergeSort(int[] arr, int start, int end){

        if(start >= end) return ;
        int mid = (start + end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, end);
    }

    public static void merge(int[] arr, int start, int end){

        int L = start;
        int mid = (start + end)/2;
        int R = mid + 1;
        int[] tempArr = new int[arr.length];
        int k = start;

        while(L <= mid && R <= end){
            tempArr[k++] = (arr[L] < arr[R])?arr[L++]:arr[R++];
        }
        if(L > mid){
            for(; R <= end; R++){
                tempArr[k++] = arr[R];
            }
        }
        else {
            for(; L <= mid; L++){
                tempArr[k++] = arr[L];
            }
        }

        for(int i = start; i <= end; i++){
            arr[i] = tempArr[i];
        }
    }
}
