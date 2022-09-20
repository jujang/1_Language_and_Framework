package Algorithm;

public class HeapSort {
    public static void main(String[] args){

        int number = 9;
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        heapSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] arr){
        heapify(arr);
        heapSorting(arr);
    }

    public static void heapify(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int child = i;
            do{
                int root = (child-1)/2;
                if(arr[child] > arr[root]){
                    int temp = arr[child];
                    arr[child] = arr[root];
                    arr[root] = temp;
                }
                child = root;
            }while(child != 0);
        }
    }

    public static void heapSorting(int[] arr){

        for(int i = arr.length-1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            int root = 0;
            int child;
            do{
                child = (root*2)+1;
                if(child+1 < i && arr[child] < arr[child+1]){
                    child++;
                }
                if(child < i && arr[root] < arr[child]){
                    int tmp = arr[root];
                    arr[root] = arr[child];
                    arr[child] = tmp;
                }
                root = child;
            } while (child < i);
        }
    }

}
