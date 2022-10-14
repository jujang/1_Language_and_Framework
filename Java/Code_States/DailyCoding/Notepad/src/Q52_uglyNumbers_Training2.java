import java.util.ArrayList;

public class Q52_uglyNumbers_Training2 {
    public static void main(String[] args) {

        int result = uglyNumbers(1);
        System.out.println(result); // --> 1

        result = uglyNumbers(3);
        System.out.println(result); // --> 3

    }

    public static int uglyNumbers(int n) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        for(int i = 0; i < n; i++){
            int uglyNum2 = arrayList.get(idx2)*2;
            int uglyNum3 = arrayList.get(idx3)*3;
            int uglyNum5 = arrayList.get(idx5)*5;

            int minVal = Math.min(uglyNum2, Math.min(uglyNum3, uglyNum5));
            arrayList.add(minVal);

            if(minVal == uglyNum2) idx2++;
            if(minVal == uglyNum3) idx3++;
            if(minVal == uglyNum5) idx5++;
        }

        return arrayList.get(n-1);
    }
}
