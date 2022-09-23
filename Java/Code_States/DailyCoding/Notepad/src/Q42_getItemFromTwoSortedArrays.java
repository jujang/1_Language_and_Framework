import java.util.Arrays;

public class Q42_getItemFromTwoSortedArrays {
    public static void main(String[] args){

        int[] arr1 = new int[]{1, 4, 8, 10};
        int[] arr2 = new int[]{2, 3, 5, 9};
        int result = getItemFromTwoSortedArrays(arr1, arr2, 6);
        System.out.println(result); // --> 8

        arr1 = new int[]{1, 1, 2, 10};
        arr2 = new int[]{3, 3};
        result = getItemFromTwoSortedArrays(arr1, arr2, 4);
        System.out.println(result); // --> 3

        arr1 = new int[]{1, 4, 8, 10};
        arr2 = new int[]{2, 3, 5, 9};
        result = getItemFromTwoSortedArrays(arr1, arr2, 5);
        System.out.println(result); // --> 5

    }

    public static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k){

        int[] newArr = new int[arr1.length+arr2.length];

        int stack = 0;
        for(int i = 0; i < arr1.length; i++){
            newArr[i] = arr1[i];
            stack++;
        }
        for(int j = 0; j < arr2.length; j++){
            newArr[stack+j] = arr2[j];
        }

        Arrays.sort(newArr);


        int low = 0;
        int high = newArr.length-1;
        int mid;

        while(low <= high){
            mid = (high+low)/2;
//            System.out.println("mid : " + mid);
            if(newArr[mid] == newArr[k-1]){
                return newArr[mid];
            }
            else if(newArr[mid] < newArr[k-1]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
