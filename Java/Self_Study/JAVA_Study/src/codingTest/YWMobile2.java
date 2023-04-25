package codingTest;

import java.util.Arrays;

public class YWMobile2 {
    public static void main(String[] args){

        String str1 = "adidas";
        String str2 = "sadiad";

        str1.toString();

        System.out.println(func(str1, str2));

    }

    public static boolean func(String str1, String str2) {

        char[] chars1 = str1.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = str2.toLowerCase().toCharArray();
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
