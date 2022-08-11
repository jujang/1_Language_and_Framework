import java.util.*;

public class Num6_re {
    public static void main(String[] args){

        ArrayList<Integer[]> output = newChickenRecipe(new int[]{1, 10, 11000, 1111}, 2);
        System.out.println(output);

        for(int i = 0; i < output.size(); i++){
            System.out.print("[");
            for(int j = 0; j < output.get(i).length; j++){
                System.out.print(output.get(i)[j]);
                System.out.print(", ");
            }
            System.out.println("]");
        }

    }

    public static ArrayList<Integer[]> newChickenRecipe(int[] arr, int rounds) {
        // TODO:

        // 결과값 반환용 arraylist 생성
        ArrayList<Integer[]> result = new ArrayList<>();

        // '0'이 3개 이상 들어있는 원소 체크
        int[] satisfyCondArr = new int[arr.length];
        int satisfyCnt = 0;
        for(int i = 0; i < arr.length; i++){
            int cnt = 0;
            for(int j = 0; j < String.valueOf(arr[i]).length(); j++){
                if(String.valueOf(arr[i]).charAt(j) == '0') cnt++;
            }
            if(cnt < 3) {
                satisfyCondArr[i] = 1;
                satisfyCnt++;
            }
        }

        // '0'이 2개 이하로 있는 원소들만을 대상으로 새로운 배열 생성
        int[] newArr = new int[satisfyCnt];
        int otherCnt = 0;
        for(int k = 0; k < satisfyCondArr.length; k++){
            if(satisfyCondArr[k] == 1) newArr[otherCnt++] = arr[k];
        }

        // 새로운 배열을 대상으로 순열 재귀함수 수행
        ArrayList<Integer[]> newArrayList = new ArrayList<>();
        result = permutation(newArrayList, new Integer[]{}, newArr, rounds);

        return result;
    }

    public static ArrayList<Integer[]> permutation (ArrayList<Integer[]> arraylist, Integer[] integerArr, int[] originArr, int leftRounds){

        // 남은 재귀 횟수가 없을 경우, 현재까지 값이 저장된 배열을 (중복 체크 후, arraylist에 추가)
        if(leftRounds == 0) {
            if(!arraylist.contains(integerArr)) {
                boolean flag = false;
                for(int x = 0; x < integerArr.length-1; x++){
                    for(int y = x+1; y < integerArr.length; y++){
//                        System.out.println((integerArr[x] == integerArr[y]) + " " + integerArr[x] + " " + integerArr[y]);
                        if((int)integerArr[x] == (int)integerArr[y]) flag = true;
                    }
                }
                if(!flag) arraylist.add(integerArr);
                return arraylist;
            }
        }

        // 받아온 배열을 복사하여 크기를 1늘리고 원소 1개 추가
        for(int i = 0; i < originArr.length; i++){
            Integer[] newArr = Arrays.copyOf(integerArr, integerArr.length+1);
            newArr[integerArr.length] = originArr[i];
            arraylist = permutation(arraylist, newArr, originArr, leftRounds-1);
        }
        return arraylist;
    }

}
