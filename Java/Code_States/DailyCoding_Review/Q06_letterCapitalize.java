import java.util.*;

public class Q06_letterCapitalize {
    public static void main(String[] args){

        String output1 = letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"
        String output2 = letterCapitalize("java  is good");
        System.out.println(output2); // "Java  Is Good"

    }

    public static String letterCapitalize(String str){

        if(str.length() == 0) return "";
        boolean flag = false;

        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);

        for(int i = 1; i < charArray.length-1; i++){
            if(charArray[i] == ' ' && charArray[i+1] != ' '){
                charArray[i+1] = Character.toUpperCase(charArray[i+1]);
                flag = true;
            }
        }

        if(flag == false) return "";

        str = String.valueOf(charArray);
        return str;
    }

}
