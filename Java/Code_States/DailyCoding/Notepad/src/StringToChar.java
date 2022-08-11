public class StringToChar {
    public static void main(String[] args){

//        String output1 = letterCapitalize("hello world");
////        String output1 = letterCapitalize("    ");
//        System.out.println(output1); // "Hello World"
//
//        String output2 = letterCapitalize("  w  ");
//        System.out.println(output2); // "Hello World"

        String test = "    ";
        System.out.println(Character.toString(test.charAt(0)).toUpperCase());
//        System.out.println(Character.isLowerCase(test.charAt(0)));
//        System.out.println(Character.isLowerCase(test[0]));
//        System.out.println(test.charAt(0));

        String test2 = " a ";
        System.out.println(Character.toString(test2.charAt(1)).toUpperCase());

        String test3 = " c ";
        char chr = 'd';

        String d = test3 + ' ';
        String e = test3 + chr;

        char test5 = 'a';
        System.out.println(Character.toString(test5).toUpperCase());  // A

    }


    public static String letterCapitalize(String str) {
        // TODO:

        String result = "";
        if(str.length() == 0) return result;

        if(Character.isLowerCase(str.charAt(0))) result += Character.toString(str.charAt(0)).toUpperCase();
        else result += str.charAt(0);
        // if(str.charAt(0).isLowerCase(x)) result += str[0].toUpperCase();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ' && i+1 < str.length()) result += Character.toString(str.charAt(i+1)).toUpperCase();
            else if(i+1 < str.length()) result += Character.toString(str.charAt(i+1));
        }

        return result;
    }
}
