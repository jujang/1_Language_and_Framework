public class Q09_ABCheck {
    public static void main(String[] args){
        boolean output = ABCheck("lane Borrowed");
        System.out.println(output); // --> true
    }

    public static boolean ABCheck(String str){
        char[] charArr = str.toCharArray();

        for(int i = 0; i < str.length()-4; i++){
            if(Character.toUpperCase(charArr[i]) == 'A' && Character.toUpperCase(charArr[i+4]) == 'B') return true;
            if(Character.toUpperCase(charArr[i]) == 'B' && Character.toUpperCase(charArr[i+4]) == 'A') return true;
        }
        return false;
    }

}
