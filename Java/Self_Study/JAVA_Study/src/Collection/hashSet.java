package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class hashSet {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("aa");
        hashSet.add("bb");
        hashSet.add("cc");
        hashSet.add("dd");

        Iterator it = hashSet.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(hashSet.contains("aa"));

        System.out.println(hashSet.isEmpty());


        ArrayList<String> abc = new ArrayList<>(hashSet);

        Iterator itt = abc.iterator();

        while(itt.hasNext()){
            System.out.println(itt.next());
        }

        System.out.println("-------");

        hashSet.remove("cc");

        Iterator it2 = hashSet.iterator();

        while(it2.hasNext()){
            System.out.println(it2.next());
        }

        System.out.println("-1-1-1-1-1-1-");

        Iterator it3 = abc.iterator();

        while(it3.hasNext()){
            System.out.println(it3.next());
        }

    }
}
