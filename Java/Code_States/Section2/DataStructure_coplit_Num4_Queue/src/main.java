import java.util.*;

public class main {
    public static void main(String args[]) {

        int[] boxes = new int[]{5, 1, 4, 6};
        int output = paveBox(boxes);
        System.out.println(output); // 3

        int[] boxes2 = new int[]{1, 5, 7, 9};
        int output2 = paveBox(boxes2);
        System.out.println(output2); // 1

        int[] boxes3 = new int[]{2, 1, 5, 4, 9, 6, 3, 6, 7, 8, 5, 5, 2, 5, 4, 7, 9};
        int output3 = paveBox(boxes3);
        System.out.println(output3); // 13

        int[] boxes4 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int output4 = paveBox(boxes4);
        System.out.println(output4); // 13

    }

    public static int paveBox(int[] boxes) {

        //기본 값 셋팅
        int maxCnt = 0;
        int thisCnt = 0;
        int thisBox = 0;

        //
        for(int i = 0; i < boxes.length; i++){
            thisCnt = 0;
            thisBox = boxes[i];
            for(int j = i; j < boxes.length; j++){
                if(thisBox >= boxes[j]) thisCnt++;
                else break;
            }
            if(maxCnt < thisCnt) maxCnt = thisCnt;
        }

        return maxCnt;
    }
}
