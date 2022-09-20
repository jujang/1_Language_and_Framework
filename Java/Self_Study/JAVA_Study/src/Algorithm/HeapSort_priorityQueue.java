package Algorithm;

import java.util.PriorityQueue;

public class HeapSort_priorityQueue {

    public static void main(String[] args){

        int number = 9;
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        heapSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] arr){

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i=0; i < arr.length; i++){
            heap.add(arr[i]);
        }

        for(int j = 0; j < arr.length; j++){
            arr[j] = heap.poll();
        }
    }



}
