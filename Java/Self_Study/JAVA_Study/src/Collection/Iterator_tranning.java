package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Iterator_tranning {
    public static void main(String[] args){

                ArrayList<String> c = new ArrayList<String>();
//        Collection c = new ArrayList<String>();

        c.add("a");
        c.add("b");
        c.add("c");

        Iterator it = c.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }


    }
}
