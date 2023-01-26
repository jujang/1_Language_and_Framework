public class CopyShallowDeep {
    public static void main(String[] args){

        int[] arr1 = {0, 1, 5, 'a'};
        int[] arr2 = arr1; // => shallow copy
        int[] arr3 = arr1.clone(); // => deep copy

        arr1[0] = 10;

        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);

        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
        System.out.println(arr3[0]);

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = new int[5];

        System.arraycopy(a, 2, b, 1, a.length-4);

        for(int e : b) {
            System.out.print(e+" ");
        }

    }
}

