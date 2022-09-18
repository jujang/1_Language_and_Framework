package Collection;

import java.util.ArrayList;
import java.util.Collections;

public class arrayList {
    public static void main(String[] args){

        ArrayList<String> arrayList = new ArrayList<String>();
        String abc = "abc";

        arrayList.add("aaa");
        arrayList.add(0, abc);


        ArrayList<String> arrayList2 = new ArrayList<String>();

        arrayList2.add("a");
        arrayList2.add("b");
        arrayList2.add("c");
        arrayList2.add("d");


//        System.out.println(arrayList.addAll(arrayList2));

        System.out.println(arrayList.addAll(0, arrayList2));


        System.out.println(arrayList);

        arrayList.get(0);
        System.out.println(arrayList.get(1));
//        System.out.println(arrayList.get(7));

        System.out.println(arrayList.set(5, "bb"));
        System.out.println(arrayList);

//        arrayList.set(7, "dd");
//        System.out.println(arrayList);

        System.out.println(arrayList.indexOf("e"));

        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println(arrayList);
        System.out.println(arrayList.remove(2));

//        System.out.println(arrayList);
//        System.out.println(arrayList.removeAll(arrayList2));
//        System.out.println(arrayList.removeAll(arrayList2));
//        System.out.println(arrayList);

        System.out.println(arrayList.contains("bb"));

        Collections.sort(arrayList);

        System.out.println("---");

//        arrayList.clear();
        System.out.println(arrayList.isEmpty());

        System.out.println(arrayList.equals(arrayList));
//        System.out.println(arrayList.size());

        System.out.println(arrayList);

        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);

        for(int i = 0; i < strArr.length; i++){
            System.out.println(strArr[i]);
        }

    }
}
