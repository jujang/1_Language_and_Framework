public class Q41_binarySearch_Training {
    public static void main(String[] args){

        int output = binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6}, 2);
        System.out.println(output); // --> 2
        System.out.println("------------------");

        output = binarySearch(new int[]{4, 5, 6, 9}, 100);
        System.out.println(output); // --> -1
        System.out.println("------------------");

        output = binarySearch(new int[]{3, 6, 7, 8, 9, 21, 31, 32}, 25);
        System.out.println(output); // --> -1
        System.out.println("------------------");

        output = binarySearch(new int[]{4, 6, 8, 9, 10, 15}, 9);
        System.out.println(output); // --> 3
        System.out.println("------------------");

        output = binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 1);
        System.out.println(output); // --> 1
        System.out.println("------------------");

        output = binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 5);
        System.out.println(output); // --> 5
        System.out.println("------------------");

        output = binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 0);
        System.out.println(output); // --> 0
    }

    public static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length-1;
        int mid;

        while(start <= end){
            mid = (start + end)/2;

            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else if(arr[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }

}
