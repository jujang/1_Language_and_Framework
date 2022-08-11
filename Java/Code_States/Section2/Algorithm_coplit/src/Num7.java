import java.util.ArrayList;
import java.util.Arrays;

public class Num7 {
    public static void main(String[] args){

        int output = boringBlackjack(new int[]{2, 3, 4, 7});
        System.out.println(output); // 1

    }

    public static int boringBlackjack(int[] cards) {
        // TODO:

        ArrayList<Integer> arraylist = new ArrayList<>();

        //        3000까지의 소수를 구해서 ArrayList에 넣기
        ArrayList<Integer> primeNumList = new ArrayList<>();
        primeNumList.add(7);

        return combination(arraylist, cards, 0, 3, primeNumList);

    }


    public static int combination (ArrayList<Integer> arraylist, int[] arr, int iterator, int leftRounds, ArrayList<Integer> primeNumList){

        int sum = 0;
        if(leftRounds == 0) {
            System.out.println(arraylist);
            int listSum = 0;
            for(int i = 0; i < arraylist.size(); i++){
                listSum += arraylist.get(i);
            }
            System.out.println(listSum);
//            listSum가 소수가 들은 ArrayList내에 포함되어 있는 값인지 체크해서 포함되어 있다면 1 반환, 아니라면 0 반환
            if(primeNumList.contains(listSum)) return 1;
            else return 0;
        }

        ArrayList<Integer> newArrayList = new ArrayList<>(arraylist);
//        ArrayList<Integer> newArrayList = arraylist;
//        for(int j = 0; j < arraylist.size(); j++){
//            newArrayList.add((arraylist.get(j)).clone());
//        }

        for(int i = iterator; i < arr.length; i++){
            newArrayList.add(arr[i]);
            sum += combination(newArrayList, arr, i+1,leftRounds-1, primeNumList);
        }

        return sum;
    }
}
