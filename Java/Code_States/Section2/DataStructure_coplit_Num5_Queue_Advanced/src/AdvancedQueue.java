import java.util.*;

public class AdvancedQueue {
    public static void main(String args[]){

////        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//
//        // Entry 객체 저장
//        map.put(1, 85);
//        map.put(2, 95);
//        map.put(3, 75);
//        map.put(4, 65);
//        map.put(5, 15);
//
//        // 저장된 총 Entry 수 얻기
//        System.out.println("총 entry 수: " + map.size());
//
//        System.out.println(map.keySet());
//        System.out.println(map.keySet().toArray()[0]);
//        System.out.println(map.entrySet().toArray()[0]);
//        System.out.println(map.values().toArray()[0]);



//        // 객체 찾기
////        System.out.println("파이리 : " + map.get("파이리"));
//
//        // key를 요소로 가지는 Set을 생성 -> 아래에서 순회하기 위해 필요합니다.
//        Set<Integer> keySet = map.keySet();
//
////        map.remove(map);
//
//        // keySet을 순회하면서 value를 읽어옵니다.
//        Iterator<Integer> keyIterator = keySet.iterator();
//        while(keyIterator.hasNext()) {
//            Integer key = keyIterator.next();
//            Integer value = map.get(key);
//            System.out.println(key + " : " + value);
//        }


        int bufferSize = 4;
        int capacities = 12;
//        int[] documents = new int[]{7, 4, 5, 6};
//        int[] documents = new int[]{10, 1, 2, 3, 4, 5, 6};
        int[] documents = new int[]{10, 1, 2, 7, 3, 4, 1, 10, 5, 6, 6};


        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println("output: "+ output);
    }

    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        // 기본 문서창 : 인쇄 요청할 문서들
        LinkedHashMap<Integer, Integer> docus = new LinkedHashMap<>();
        for(int i = 0; i < documents.length; i++){
            docus.put(documents[i], 0);
        }

        // 프린터 대기열 : 프린트 진행중인 문서
        LinkedHashMap<Integer, Integer> waitDocus = new LinkedHashMap<>();

        int currentBufferSize = 0; // 프린터의 현재 사용중인 버퍼 메모리
        int timer = 0; // 걸린 시간

        while(true){
            timer++; // 시간 경과
            System.out.println("timer: "+ timer);

            // 프린트 대기열에서 자리 하나씩 땡기기
            if(!waitDocus.isEmpty()) {
                Set<Integer> keySet = waitDocus.keySet();
                Iterator<Integer> keyIterator = keySet.iterator();
                while(keyIterator.hasNext()) {
                    Integer key = keyIterator.next();
                    Integer value = waitDocus.get(key);
                    waitDocus.put(key, --value);
                    }
                int thisKey = (int) waitDocus.keySet().toArray()[0];
                if(waitDocus.get(thisKey) == 0) {  // 만약 가장 최앞단의 프린터기에서 과정이 모두 끝난다면 해당 문서를 queue(대기열)에서 빼내기(remove = pop)
                    System.out.println("waitDocus에서 pop되는 key값: " + thisKey); // 8
                    waitDocus.remove(thisKey);
                    currentBufferSize -= thisKey;
                }
            }

            // 만약 프린트 대기열과 프린트할 목록이 없다면 프로그램 종료
            if(waitDocus.isEmpty() && docus.isEmpty()) break;

            // 프린터기에 다음 문서를 대기시킬 메모리가 남아있다면 가져오기 (queue push / currentBufferSize 증가)
            if(!docus.isEmpty()){
                if(currentBufferSize + (int)docus.keySet().toArray()[0] <= capacities && waitDocus.size() < bufferSize) {
//                if(currentBufferSize + (int)docus.keySet().toArray()[0] <= capacities) {
                    currentBufferSize += (int)docus.keySet().toArray()[0];
                    System.out.println("docus에서 들어오는 key값: " + docus.keySet().toArray()[0]);
                    waitDocus.put((Integer)docus.keySet().toArray()[0], bufferSize);
                    docus.remove(docus.keySet().toArray()[0]);
                }
            }
            System.out.println("-----------------------------------------------------");
        }
        return timer;
    }
}
