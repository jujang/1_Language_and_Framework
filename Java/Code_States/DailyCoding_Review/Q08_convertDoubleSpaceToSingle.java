public class Q08_convertDoubleSpaceToSingle {
    public static void main(String[] args){

        String output = convertDoubleSpaceToSingle("string  with  double  spaces");
        System.out.println(output);

        System.out.println("==============================================");

        String output2 = convertDoubleSpaceToSingle("this here string");
        System.out.println(output2);

    }

    public static String convertDoubleSpaceToSingle(String str){

        String newStr = "";
        if(str.length() == 0) return newStr;

        char[] charArr = str.toCharArray();

        for(int i = 0; i < charArr.length - 1; i++){
            if(charArr[i] == ' ' && charArr[i+1] == ' ') {

            } else {
                newStr += charArr[i];
            }
        }
        newStr += charArr[charArr.length-1];

        return newStr;
    }
}
