package Collection;

import java.util.Collection;
import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
import java.util.Set;

public class hashMap {
    public static void main(String[] args){

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        hashMap.put("abc", 1);
        hashMap.put("aaa", 2);
        hashMap.put("bbb", 3);
        hashMap.put("ccc", 4);

//        System.out.println(hashMap.get("abc"));
//        System.out.println(hashMap.get("aaa"));
//        System.out.println(hashMap.get("bbb"));
//        System.out.println(hashMap.get("ccc"));


        Set<HashMap.Entry<String, Integer>> entries = hashMap.entrySet();
        for(HashMap.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }



        Set<String> sets = hashMap.keySet();

        for(String set : sets) {
            System.out.println(set);
        }


        Collection<Integer> sets2 = hashMap.values();

        for(int set1 : sets2) {
            System.out.println(set1);
        }


        System.out.println(hashMap.get("aaa"));
        hashMap.remove("aaa");

        hashMap.clear();
        System.out.println(hashMap.get("bbb"));

    }
}
