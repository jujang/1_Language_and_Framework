public class Q20_compressString {
    public static void main(String[] args){

        String output = compressString("abc");
        System.out.println(output); // --> "abc"

        output = compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"

        output = compressString("wwwggopp");
        System.out.println(output); // --> "3wggopp"

    }

    public static String compressString(String str) {
        // TODO:
        String newStr = "";
        int cnt = 1;
        char prevChar;
        if(str.length() == 0) return newStr;
        else prevChar = str.charAt(0);

        for(int i = 1; i <= str.length(); i++){
            if (i == str.length()) {
                if(cnt > 2) newStr += cnt;
                else if(cnt == 2) newStr += prevChar;
                newStr += prevChar;
            }
            else {
                if(prevChar == str.charAt(i)) cnt++;
                else {
                    if(cnt > 2) newStr += cnt;
                    else if(cnt == 2) newStr += prevChar;
                    newStr += prevChar;
                    cnt = 1;
                    prevChar = str.charAt(i);
                }
            }
        }
        return newStr;
    }

}
