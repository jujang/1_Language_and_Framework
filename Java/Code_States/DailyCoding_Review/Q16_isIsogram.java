import java.util.*;

public class Q16_isIsogram {
    public static void main(String[] args){
        boolean output = isIsogram("aba");
        System.out.println(output); // false

        output = isIsogram("Dermatoglyphics");
        System.out.println(output); // true

        output = isIsogram("moOse");
        System.out.println(output); // false
    }

    public static boolean isIsogram(String str){
        char[] charArr = str.toUpperCase().toCharArray();

        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < charArr.length; i++){
            if(hashSet.contains(charArr[i])) return false;
            hashSet.add(charArr[i]);
        }
        return true;
    }
}
