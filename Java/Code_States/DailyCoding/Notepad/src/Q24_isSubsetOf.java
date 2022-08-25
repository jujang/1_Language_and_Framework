import java.util.*;
import java.util.stream.Collectors;

public class Q24_isSubsetOf {
    public static void main(String[] args){

        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};
        boolean output = isSubsetOf(base, sample);
        System.out.println(output); // --> true

        sample = new int[]{6, 7};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false

        base = new int[]{10, 99, 123, 7};
        sample = new int[]{11, 100, 99, 123};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false

    }

    public static boolean isSubsetOf(int[] base, int[] sample) {
        // TODO:

        ArrayList<Integer> arrayList = Arrays.stream(base).boxed().collect(Collectors.toCollection(ArrayList::new));
        HashSet<Integer> set = new HashSet<Integer>(arrayList);

//        if(set.contains(sample)) return true;

        for(int i = 0; i < sample.length; i++){
//            if(!set.contains(sample[i])) return false;
            if(!arrayList.contains(sample[i])) return false;
        }

        return true;
    }

}
