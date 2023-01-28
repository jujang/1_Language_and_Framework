public class Q08_convertDoubleSpaceToSingle {
    public static void main(String[] args){

        String output = convertDoubleSpaceToSingle("string  with  double  spaces");
        System.out.println(output);

        System.out.println("==============================================");

        String output2 = convertDoubleSpaceToSingle("this here string");
        System.out.println(output2);

    }

    public static String convertDoubleSpaceToSingle(String str){

        String[] strArr = str.split(" ");

        String newStr = strArr[0];
        for(int i = 1; i < strArr.length; i++){
            System.out.println(strArr[i]);
            newStr = newStr + " " + strArr[i];
        }
        return newStr;

    }
}
