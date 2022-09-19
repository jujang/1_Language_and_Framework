public class heap {
    public static void main(String[] args){

        int number = 9;
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        // 먼저 전체 트리 구조를 (최대)힙 구조로 바꿉니다.
        for(int i = 1; i < arr.length; i++){
            int c = i;
            do{
//                System.out.println(c);
                int root = (c-1) / 2;
                if(arr[root] < arr[c]) {
                    int temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                c = root;
            } while(c != 0);
        }

        //크기를 줄여가며 반복적으로 힙을 구성
        for(int j = number -1; j >= 0; j--){
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            int root = 0;
            int child;
            do{
                child = 2 * root + 1;
                // 자식 중에 더 큰 값을 찾기
                if(child < j-1 && arr[child] < arr[child+1]){
                    child++;
                }
                // 루트보다 자식이 더 크다면 교환
                if(child < j && arr[root] < arr[child]) {
                    temp = arr[root];
                    arr[root] = arr[child];
                    arr[child] = temp;
                }
                root = child;
            } while(child < j);
        }

        for(int k = 0; k < number; k++){
            System.out.print(arr[k] + " ");
        }

    }
}
