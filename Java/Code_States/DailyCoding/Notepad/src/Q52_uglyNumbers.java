import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q52_uglyNumbers {
    public static void main(String[] args){

        int result = uglyNumbers(15);
        System.out.println(result); // --> 24

        System.out.println("==============================");

        result = uglyNumbers(8);
        System.out.println(result); // --> 9

    }

    public static int uglyNumbers(int n) {
        // TODO:
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;


        for(int i = 0; i < n; i++){

            int uglyNum2 = arrayList.get(index2)*2;
            int uglyNum3 = arrayList.get(index3)*3;
            int uglyNum5 = arrayList.get(index5)*5;

            int minVal = Math.min(uglyNum2, Math.min(uglyNum3, uglyNum5));
            arrayList.add(minVal);

            if(uglyNum2 == minVal) index2++;
            if(uglyNum3 == minVal) index3++;
            if(uglyNum5 == minVal) index5++;

        }

        return arrayList.get(n-1);
    }

}
