import java.util.*;
public class Q11_removeExtremes {
    public static void main(String[] args){
        String[] aa = new String[]{"a", "b", "c", "def"};
        System.out.println(aa);
        String[] output = removeExtremes(aa);
        System.out.println(output); // --> ["a"', "b"]

        output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(output); // --> ["where", "the", "word"]
    }
    public static String[] removeExtremes(String[] arr) {

        if(arr.length == 0) return null;

        int strLowCnt = arr[0].length();
        int strLowIdx = 0;
        int strHighCnt = arr[0].length();
        int strHighIdx = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i].length() >= strHighCnt) {
                strHighCnt = arr[i].length();
                strHighIdx = i;
            }
            if(arr[i].length() <= strLowCnt) {
                strLowCnt = arr[i].length();
                strLowIdx = i;
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for(int j = 0; j < arr.length; j++){
            if(j != strHighIdx && j != strLowIdx){
                arrayList.add(arr[j]);
            }
        }
        String[] newArr = arrayList.toArray(new String[]{});

        return newArr;
    }

}
