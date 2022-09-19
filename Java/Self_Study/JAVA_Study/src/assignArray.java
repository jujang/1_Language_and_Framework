public class assignArray {
    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5};

        int[] arr2 = {0, 1, 2, 3, 4};

//        arr = arr2;
//        arr2[2] = 1;

        for(int k = 0; k < arr.length; k++){
            arr[k] = arr2[k];
        }

        arr2[2] = 1;

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
