import java.util.*;

public class doubleArrayList {
    public static void main(String args[]){

        int bufferSize = 2;
        int capacities = 5;
        int[] documents = new int[]{5, 2, 3, 2, 1, 2};


        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println("output: "+ output);
    }

    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {

        // 기본 문서창 : 인쇄 요청할 문서들
        ArrayList<Integer> waitingList = new ArrayList<>();
        for(int i = 0; i < documents.length; i++){
            waitingList.add(documents[i]);
        }

        ArrayList<Integer> workingListSize = new ArrayList<>();
        ArrayList<Integer> workingListBuffer = new ArrayList<>();


        int currentBufferSize = 0; // 프린터의 현재 사용중인 버퍼 메모리
        int timer = 0; // 걸린 시간

        while(true){
            timer++; // 시간 경과
            System.out.println("timer: "+ timer);

            // 프린트 대기열에서 자리 하나씩 땡기기
            if(!workingListSize.isEmpty()) {
                for(int j = 0; j < workingListSize.size(); j++){
                    workingListBuffer.set(j, workingListBuffer.get(j)-1);
                }
                int thisKey = workingListSize.get(0);
                if(workingListBuffer.get(0) == 0){
                    System.out.println("workingList에서 pop되는 요소: " + thisKey);
                    currentBufferSize -= thisKey;
                    workingListSize.remove(0);
                    workingListBuffer.remove(0);
                }
            }

            // 만약 프린트 대기열과 프린트할 작업 목록이 없다면 프로그램 종료
            if(waitingList.isEmpty() && workingListSize.isEmpty()) break;

            // 프린터기에 다음 문서를 대기시킬 메모리가 남아있다면 가져오기 (queue push / currentBufferSize 증가)
            if(!waitingList.isEmpty()){
                if(currentBufferSize + waitingList.get(0) <= capacities && workingListSize.size() < bufferSize) {
                    currentBufferSize += waitingList.get(0);
                    System.out.println("waitingList에서 들어오는 key값: " + waitingList.get(0));
                    workingListSize.add(waitingList.get(0));
                    workingListBuffer.add(bufferSize);
                    waitingList.remove(0);
                }
            }
        }

        return timer;
    }
}
