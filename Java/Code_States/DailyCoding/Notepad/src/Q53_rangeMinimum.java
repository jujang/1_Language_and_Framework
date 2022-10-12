public class Q53_rangeMinimum {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 2, 7, 9, 11};
        int[][] ranges = new int[][]{
                {1, 4},
                {0, 3}
        };
        int[] mins = rangeMinimum(arr, ranges);
//        System.out.println(mins); // --> [2, 1]

        for(int i = 0; i < mins.length; i++){
            System.out.println(mins[i]);
        }

    }

    public static int[] rangeMinimum(int[] arr, int[][] ranges) {
        // TODO:
        int[] result = new int[ranges.length];
        int min;

        for(int i = 0; i < ranges.length; i++){
            min = arr[ranges[i][0]];
            for(int j = ranges[i][0]; j < ranges[i][1]; j++){
                if(min > arr[j]) min = arr[j];
            }
            result[i] = min;
        }

        return result;
    }
}
