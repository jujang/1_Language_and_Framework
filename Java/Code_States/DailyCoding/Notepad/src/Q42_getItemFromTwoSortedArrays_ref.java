public class Q42_getItemFromTwoSortedArrays_ref {
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

    public static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        int leftIdx = 0;
        int rightIdx = 0;
        while (k > 0) {
            // 이진 탐색을 위해 각 배열에서 k를 절반으로 쪼개서 카운트 한다.
            int cnt = (int)Math.ceil(((double) k) / 2);
            int leftStep = cnt;
            int rightStep = cnt;

            // 엣지 케이스
            // 카운트가 남았음에도 배열의 끝에 도달하면 k를 나머지 배열쪽으로 넘긴다.
            if (leftIdx == arr1.length) {
                rightIdx = rightIdx + k;
                break;
            }

            if (rightIdx == arr2.length) {
                leftIdx = leftIdx + k;
                break;
            }

            // 엣지 케이스
            // 현재 카운트가 남아있는 후보 요소들보다 많을 경우, leftStep(현재 할당량)을 남아있는 요소들의 개수로 바꾼다.
            if (cnt > arr1.length - leftIdx) leftStep = arr1.length - leftIdx;
            if (cnt > arr2.length - rightIdx) rightStep = arr2.length - rightIdx;

            // 두 배열의 현재 검사 요소 위치를 비교해서, 그 값이 작은 배열은 비교한 위치 앞에 있는 요소들을 모두 후보군에서 제외시킨다.
            if (arr1[leftIdx + leftStep - 1] < arr2[rightIdx + rightStep - 1]) {
                leftIdx = leftIdx + leftStep;
                // 처리가 끝나면 k값을 절반으로 떨어뜨린다.
                k = k - leftStep;
            } else {
                rightIdx = rightIdx + rightStep;
                k = k - rightStep;
            }
        }
        int leftMax = (leftIdx - 1 < arr1.length) ? arr1[leftIdx - 1] : -1;
        int rightMax = (rightIdx - 1 < arr2.length) ? arr2[rightIdx - 1] : -1;

        return Math.max(leftMax, rightMax);
    }


}
