public class Array {
    public static void main(String[] args){

        int[] arr = new int[5];
        arr[0] = 1;
        arr[2] = 0;
        arr[3] = 10;
        arr[4] = 'a';
        for(int var : arr){
            System.out.println(var);
        }
        System.out.println(arr);
        System.out.println(arr.length);

    }
}
