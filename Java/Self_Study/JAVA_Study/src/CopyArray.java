import java.util.*;

public class CopyArray {
    public static void main(String[] args){

        int[] a = {1, 2, 3, 4, 5};
        int[] b = a.clone();
        System.out.println(a);
        System.out.println(b);

        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }

        int[] c = Arrays.copyOf(b, 2);

        for(int j = 0; j < c.length; j++){
            System.out.println(c[j]);
        }

        int[] d = new int[b.length+1];
        d = Arrays.copyOf(b, b.length);

        System.out.println("d.length: "+ d.length);
        for(int k = 0; k < d.length; k++){
            System.out.println(d[k]);
        }


        int[] e = Arrays.copyOf(b, b.length+1);

        System.out.println("e.length: "+ e.length);
        for(int l = 0; l < e.length; l++){
            System.out.print(e[l] + " ");
        }

    }
}
