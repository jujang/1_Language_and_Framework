public class Q38_mergeSort {
    public static void main(String[] args){

        int[] output = mergeSort(new int[]{3, 1, 21});


        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " ");
        }

    }

    public static int[] mergeSort(int[] arr){

        divide(arr, 0, arr.length-1);
        return arr;
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
            tempArr[k++] = (arr[L] < arr[R])?arr[L++]:arr[R++];
        }
        if(L > mid){
            for(; R <= end; R++){
                tempArr[k++] = arr[R];
            }
        } else {
            for(; L <= mid; L++){
                tempArr[k++] = arr[L];
            }
        }

        for(int i = start; i <= end; i++){
            arr[i] = tempArr[i];
        }
    }

}
