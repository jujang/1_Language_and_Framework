public class Q20_compressString {
    public static void main(String[] args){
        String output = compressString("abc");
        System.out.println(output); // --> "abc"

        output = compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
    }

    public static String compressString(String str) {
        // TODO:
        str += " ";
        String newStr = "";

        int sameCnt = 0;
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                sameCnt++;
            } else {
                if(sameCnt > 1) {
                    newStr += (sameCnt+1);
                    newStr += Character.toString(str.charAt(i));
                } else if(sameCnt == 1){
                    newStr = newStr + Character.toString(str.charAt(i)) + Character.toString(str.charAt(i));
                } else {
                    newStr = newStr + Character.toString(str.charAt(i));
                }
                sameCnt = 0;
            }
        }
        return newStr;
    }

}
