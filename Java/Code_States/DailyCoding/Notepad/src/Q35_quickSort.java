public class Q35_quickSort {
    public static void main(String[] args){

//        int[] output = quickSort(new int[]{3, 1, 21});
//        int[] output = quickSort(new int[]{20, -10, -11, 2, 29});
        int[] output = quickSort(new int[]{1, 2, 43, 100, 21});

        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " ");
        }

    }

    public static int[] quickSort(int[] arr){

        quickSortIn(arr, 0, arr.length-1);

        return arr;

    }

    public static int[] quickSortIn(int[] arr, int start, int end){
        int part = partition(arr, start, end);
        if(start < part-1) quickSortIn(arr, start, part-1);
        if(part < end) quickSortIn(arr, part, end);
        return arr;
    }

    public static int partition(int[] arr, int start, int end){

        int pivot = arr[(start + end) / 2];
        while(start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
