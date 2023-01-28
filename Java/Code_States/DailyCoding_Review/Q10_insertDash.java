public class Q10_insertDash {
    public static void main(String[] args){
        String output = insertDash("454793");
        System.out.println(output); // --> 4547-9-3
    }
    public static String insertDash(String str){

        if(str.length() == 0) return null;
        String newStr = "";
        char[] charArr = str.toCharArray();
        for(int i = 0; i < str.length()-1; i++){
            newStr += charArr[i];
            if((charArr[i]-'0')%2 == 1 && (charArr[i+1]-'0')%2 == 1){
                newStr += "-";
            }
        }
        newStr += charArr[str.length()-1];

        return newStr;
    }
}
