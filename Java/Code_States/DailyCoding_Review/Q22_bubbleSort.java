public class Q22_bubbleSort {
    public static void main(String[] args){

        int[] output = bubbleSort(new int[]{2, 1, 3});
        for(int a = 0; a < output.length; a++){
            System.out.print(output[a] + " ");
        }
        System.out.println("");
//        System.out.println(output); // --> [1, 2, 3]

        output = bubbleSort(new int[]{4, 1, 5, 3, 2});
        for(int a = 0; a < output.length; a++){
            System.out.print(output[a] + " ");
        }
        System.out.println("");
//        System.out.println(output); // --> [1, 2, 3, 4, 5]

        output = bubbleSort(new int[]{20, -10, -11, 2, 4, 299});
        for(int a = 0; a < output.length; a++){
            System.out.print(output[a] + " ");
        }
        System.out.println("");
//        System.out.println(output); // --> [-11, -10, 2, 4, 20, 299]

    }

    public static int[] bubbleSort(int[] arr) {
        // TODO:

        int[] newArr = arr.clone();

        boolean flag = false;

        for(int i = newArr.length-1; i > 0; i--){
            for(int j = 0;  j < i; j++){
                int temp;
                if(newArr[j] > newArr[j+1]) {
                    temp = newArr[j];
                    newArr[j] = newArr[j+1];
                    newArr[j+1] = temp;
                    flag = true;
                }
            }
            if(flag == false) break;
        }

        return newArr;
    }
}
