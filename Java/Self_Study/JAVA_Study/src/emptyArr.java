public class emptyArr {
    public static void main(String[] args){

        char[] charArr = new char[5];
        for(int i = 0; i < charArr.length; i++) System.out.println(charArr[i]);


        String[] StringArr = new String[5];
        for(int j = 0; j < StringArr.length; j++) System.out.println(StringArr[j]);


        int[] arr = new int[]{};
        System.out.println(arr);

    }
}
