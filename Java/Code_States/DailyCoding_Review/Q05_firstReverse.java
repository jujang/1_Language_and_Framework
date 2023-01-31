public class Q05_firstReverse {
    public static void main(String[] args){
        String output = firstReverse("codestates");
        System.out.println(output); // "setatsedoc"

        output = firstReverse("I love codestates");
        System.out.println(output); // "setatsedoc evol I"
    }
    public static String firstReverse(String str) {
        String newStr = "";
        int cnt = str.length();
        for(int i = cnt-1; i >= 0; i--){
            newStr += str.charAt(i);
        }
        return newStr;
    }
}
