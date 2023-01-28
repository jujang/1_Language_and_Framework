public class Q13_readVertically {
    public static void main(String[] args){
        String[] input = new String[]{"hello", "wolrd"};
        String output = readVertically(input);
        System.out.println(output); // --> "hweolllrod"

        input = new String[]{"hi", "wolrd"};
        output = readVertically(input);
        System.out.println(output); // --> "hwiolrd"
    }

    public static String readVertically(String[] arr){

        String newStr = "";
        if(arr.length == 0) return newStr;

        int maxCnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length() > maxCnt) maxCnt = arr[i].length();
        }

        for(int j = 0; j < maxCnt; j++){
            for(int k = 0; k < arr.length; k++){
                if(arr[k].length() > j) {
                    newStr += arr[k].charAt(j);
                }
            }
        }
        return newStr;
    }

}
