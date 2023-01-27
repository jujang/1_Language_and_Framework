import java.util.ArrayList;
import java.util.Collections;

public class Q31_powerSet {
    public static void main(String[] args){

        ArrayList<String> output1 = powerSet("abc");
        System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

        ArrayList<String> output2 = powerSet("jjump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
    }

    public static ArrayList<String> powerSet(String str){

        // 반환할 arrayList
        ArrayList<String> abc = new ArrayList<>();

        String newStr = "~";
        newStr = newStr.concat(str);
        System.out.println(newStr);

        //
        for(int i = 0; i < Math.pow(2, newStr.length()); i++){

//            System.out.println("-------");

            boolean flag = true;

            ArrayList<Character> miniList = new ArrayList<>();
            for(int j = 0; j < newStr.length(); j++){
                if((j & i) > 0) {
                    miniList.add(newStr.charAt(j));
                }
//                System.out.println(j&i);

//                if(!miniList.contains(str.charAt(i&j))) {
//                    miniList.add((str.charAt(i&j)));
//                }
            }
//            System.out.println(miniList);
            Collections.sort(miniList);
            for(int k = 0; k < miniList.size() - 1; k++){
                if(miniList.get(k) == miniList.get(k+1)) flag = false;
            }

            String combiStr = "";
            for(int m = 0; m < miniList.size(); m++) {
                combiStr += miniList.get(m);
            }

            if(flag == true && !(abc.contains(combiStr)) ) {
                abc.add(combiStr);
            }
        }

        Collections.sort(abc);
        return abc;
    }
}
