package Algorithm;

public class MergeSort_Training_2 {

    public static void main(String[] args){

        int number = 9;
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        mergeSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr){

        divide(arr, 0, arr.length-1);
    }

    public static void divide(int[] arr, int start, int end){

        if(start == end) return ;
        int mid = (start + end)/2;
        divide(arr, start, mid);
        divide(arr, mid+1, end);
        merge(arr, start, end);
    }


    public static void merge(int[] arr, int start, int end){

        int L = start;
        int mid = (start + end)/2;
        int R = mid+1;
        int k = start;

        int[] tempArr = new int[arr.length];

        while(L <= mid && R <= end){
            tempArr[k++] = (arr[L] < arr[R])? arr[L++]:arr[R++];
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
