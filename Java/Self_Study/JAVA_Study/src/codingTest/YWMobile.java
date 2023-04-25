package codingTest;

import java.util.HashMap;
import java.util.Iterator;

public class YWMobile {

    public static void main(String[] args) {

        String str1 = "adidas";
        String str2 = "sadiad";

        System.out.println(func(str1, str2));

    }

    public static boolean func(String str1, String str2){

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            if(hashMap1.containsKey(str1.charAt(i))){
                hashMap1.put(str1.charAt(i), hashMap1.get(str1.charAt(i))+1);
            } else {
                hashMap1.put(str1.charAt(i), 1);
            }
        }

        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for(int i = 0; i < str2.length(); i++){
            if(hashMap2.containsKey(str2.charAt(i))){
                hashMap2.put(str2.charAt(i), hashMap2.get(str2.charAt(i))+1);
            } else {
                hashMap2.put(str2.charAt(i), 1);
            }
        }

        if(hashMap1.size() != hashMap2.size()){
            return false;
        } else {
            Iterator entries = hashMap1.keySet().iterator();
            while(entries.hasNext()){
                Character chr = (Character) entries.next();
                if(hashMap1.get(chr) != hashMap2.get(chr)){
                    return false;
                }
            }
        }

        return true;
    }

}
