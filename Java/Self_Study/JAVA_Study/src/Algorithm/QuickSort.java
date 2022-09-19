package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args){

//        int[] arr = {7,4,2,3,5,1,6};
//        int[] arr = {7,4,2,8,3,5,1,6,10,9};
        int[] arr = {1, 2, 43, 100, 21};

        quickSort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        int part = partition(arr, start, end);
        if(start < part-1) quickSort(arr, start, part-1);
        if(part < end) quickSort(arr, part, end);
    }

    public static int partition(int[] arr, int start, int end){

        int pivot = arr[(start + end)/2];
        while(start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

}