public class IntToString {
    public static void main(String[] args){

        int abc = 123;
        String str = String.valueOf(abc);
        System.out.println(str);

        String str2 = Integer.toString(abc);
        System.out.println(str2);

        if(str == str2) System.out.println("!");
        if(str.equals(str2)) System.out.println("!!");


        String test1 = "aaa";
        String test2 = "aaa";

        if(test1 == test2) System.out.println("?");

    }
}
