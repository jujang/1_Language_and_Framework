import java.util.*;

public class numReal6 {
    public static void main(String args[]){


//        Integer[] test = new Integer[]{111, 222};

//        ArrayList<Integer> testtest = new ArrayList<>();
//        testtest.add(1);
//        testtest.add(2);
//        testtest.add(3);
//        testtest.add(4);
//        System.out.println(testtest);

        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1010, 110000, 1111}, 4);

        for(int i = 0; i < output1.size(); i++){
//            System.out.println(new int[]{(int[])output1.get(i)});
            System.out.print("[ ");
            for(int j = 0; j < output1.get(i).length; j++){
                System.out.print(output1.get(i)[j]);
                System.out.print(", ");
            }
            System.out.println("]");
        }

    }

    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:

        ArrayList<Integer[]> result = new ArrayList<>();

        int[] checkArr = new int[stuffArr.length];
        // 1. 배열로 들어온 값에서 0이 3개 이상인 원소를 제거
        for(int i = 0; i < stuffArr.length; i++){
            int cnt = 0;
            for(int j = 0; j < String.valueOf(stuffArr[i]).length(); j++){
                if(String.valueOf(stuffArr[i]).charAt(j) == '0') cnt++;
            }
            if(cnt >= 3) checkArr[i] = 1; // 1이면 0이 3개 이상
        }

        ArrayList<Integer> container = new ArrayList<>();
        for(int k = 0; k < stuffArr.length; k++){
            if(checkArr[k] == 0) container.add(stuffArr[k]);
        }

        // 2. 나머지 원소들을 오름차순으로 정렬
        Collections.sort(container);

        // 3. 조합 가능한 배열의 개수가 선택할 원소의 개수보다 작을 경우 null 반환
        if(container.size() < choiceNum) {
            System.out.println("개수 부족");
            return null;
        }

        Integer[] array = container.toArray(new Integer[0]);
//        System.out.println(array[0]);
        // 4. 재귀 함수를 사용해서 배열 생성 및 arraylist에 넣기 진행
        ArrayList<Integer[]> oneUseArrayList = new ArrayList<>();
        result = permutation(array, new Integer[]{}, choiceNum, oneUseArrayList);

        // 5. arrayList 반환
        return result;
    }


    // array는 재귀시킬 배열이 들어있음
    // currentLeftNum은 선택할 남은 개수
    // oneUseArrayList는 현재 선택된 배열들이 들어있음
    public static ArrayList<Integer[]> permutation( Integer[] orginArr, Integer[] array, int currentLeftNum, ArrayList<Integer[]> oneUseArrayList) {

        if(currentLeftNum == 0) {
            if(!oneUseArrayList.contains(array)) {
                oneUseArrayList.add(array);
            }
//            System.out.println(oneUseArrayList);
            return oneUseArrayList;
        }

        Integer[] newArr = Arrays.copyOf(array, array.length+1);

        for(int i = 0; i < orginArr.length; i++){
            if(!Arrays.asList(newArr).contains(orginArr[i])) newArr[array.length] = orginArr[i];
            oneUseArrayList = permutation(orginArr, newArr, currentLeftNum-1, oneUseArrayList);
        }

        return oneUseArrayList;
    }
}
