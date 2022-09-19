public class heap_training {
    public static void main(String[] args){

        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        heapSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void heapSort(int[] arr){
        heapify(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        sort(arr);
    }

//    public static void heapify(int[] arr){
//        // 먼저 전체 트리 구조를 (최대)힙 구조로 바꿉니다.
//        for(int i = 1; i < arr.length; i++){
//            int child = i;
//            do{
////                System.out.println(c);
//                int root = (child-1) / 2;
//                if(arr[root] < arr[child]) {
//                    int temp = arr[root];
//                    arr[root] = arr[child];
//                    arr[child] = temp;
//                }
//                child = root;
//            } while(child != 0);
//        }
//    }

//    public static void sort(int[] arr){
//        //크기를 줄여가며 반복적으로 힙을 구성
//        for(int j = arr.length -1; j >= 0; j--){
//            int temp = arr[0];
//            arr[0] = arr[j];
//            arr[j] = temp;
//
//            int root = 0;
//            int child;
//            do{
//                child = 2 * root + 1;
//                // 자식 중에 더 큰 값을 찾기
//                if(child < j-1 && arr[child] < arr[child+1]){
//                    child++;
//                }
//                // 루트보다 자식이 더 크다면 교환
//                if(child < j && arr[root] < arr[child]) {
//                    temp = arr[root];
//                    arr[root] = arr[child];
//                    arr[child] = temp;
//                }
//                root = child;
//            } while(child < j);
//        }
//    }

    public static void heapify(int[] arr) {

        for(int i = 1; i < arr.length; i++){
            int child = i;
            do{
                int root = (child-1)/2;
                if(arr[child] > arr[root]){
                    int temp = arr[child];
                    arr[child] = arr[root];
                    arr[root] = temp;
                }
                child = root;
            } while(child != 0);
        }
    }

    public static void sort(int[] arr){

        for(int j = arr.length-1; j >= 0; j--){
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            int root = 0;
            int child;
            do{
                child = (root*2) + 1;
                if(child+1 < j && arr[child] < arr[child+1]){
                    child++;
                }
                if(child < j && arr[root] < arr[child]){
                    int tmp = arr[child];
                    arr[child] = arr[root];
                    arr[root] = tmp;
                }
                root = child;
            }while(child < j);
        }
    }
}
