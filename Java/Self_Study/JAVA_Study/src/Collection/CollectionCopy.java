package Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
public class CollectionCopy {
    public static void main(String[] args){

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("aa");
        hashSet.add("bb");
        hashSet.add("cc");
        hashSet.add("dd");


        ArrayList<String> abc = new ArrayList<>(hashSet);
        hashSet.remove("cc");

        Iterator itt = abc.iterator();
        while(itt.hasNext()){
            System.out.println(itt.next());
        }

        System.out.println("----------------------------");

        Iterator it = hashSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
