public class Q36_insetionSort {
    public static void main(String[] args){

        int[] output = insertionSort(new int[]{3, 1, 21});

        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " ");
        }
    }

    public static int[] insertionSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]) swap(arr, j, j-1);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int x, int y){

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
