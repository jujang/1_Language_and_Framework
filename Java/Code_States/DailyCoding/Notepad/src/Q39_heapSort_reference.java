import java.util.PriorityQueue;

public class Q39_heapSort_reference {

    public static void main(String[] args){

        int[] output = heapSort(new int[]{5, 4, 3, 2, 1});

        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " "); // --> [1, 2, 3, 4, 5]
        }
        System.out.println("");

        output = heapSort(new int[]{3, 1, 21});
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " "); // --> [1, 2, 3, 4, 5]
        }
        System.out.println("");

        output = heapSort(new int[]{4, 10, 3, 5, 1});
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " "); // --> [1, 2, 3, 4, 5]
        }
        System.out.println("");
    }

    public static int[] heapSort(int[] arr){

        // 힙(우선순위 큐) 생성
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // 배열의 값을 힙에 모두 할당함
        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
        }

        // 힙에서 우선순위가 가장 높은 원소(root 노드)를 하나씩 배열에 넣어줌
        for(int i = 0; i < arr.length; i++){
            arr[i] = heap.poll();
        }

        return arr;
    }

}
