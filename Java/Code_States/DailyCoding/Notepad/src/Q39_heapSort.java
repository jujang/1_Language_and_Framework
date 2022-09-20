public class Q39_heapSort {
    public static void main(String[] args){

        int[] output = heapSort(new int[]{5, 4, 3, 2, 1});

        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " "); // --> [1, 2, 3, 4, 5]
        }
        System.out.println("");

        output = heapSort(new int[]{3, 1, 21});
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " "); // --> [1, 2, 3, 4, 5]
        }
        System.out.println("");

        output = heapSort(new int[]{4, 10, 3, 5, 1});
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " "); // --> [1, 2, 3, 4, 5]
        }
        System.out.println("");
    }

    public static int[] heapSort(int[] arr){

        heapify(arr);
        heapSorting(arr);

        return arr;
    }

    public static void heapify(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int child = i;
            do{
                int root = (child-1)/2;
                if(arr[root] < arr[child]){
                    int temp = arr[root];
                    arr[root] = arr[child];
                    arr[child] = temp;
                }
                child = root;
            } while(child != 0);
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
            } while(root < i);
        }
    }
}
