package Algorithm;

public class InsertionSort {
    public static void main(String[] args){

        int[] arr = {5, 7, 1, 4, 3};

        insertionSort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void insertionSort(int[] arr, int start, int end){

        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]) swap(arr, j, j-1);
            }
        }

    }

    public static void swap(int[] arr, int start, int end){

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
