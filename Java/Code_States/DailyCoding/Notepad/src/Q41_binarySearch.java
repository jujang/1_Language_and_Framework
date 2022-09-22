public class Q41_binarySearch {
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

    public static int binarySearch(int[] arr, int target){

        int low = 0;
        int high = arr.length-1;
        int mid;

        while(low <= high){
            mid = (low + high)/2;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

}
