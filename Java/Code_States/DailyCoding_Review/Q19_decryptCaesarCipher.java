public class Q19_decryptCaesarCipher {
    public static void main(String[] args){
        String output = decryptCaesarCipher("khoor", 3);
        System.out.println(output); // --> hello

        output = decryptCaesarCipher("zruog", 3);
        System.out.println(output); // --> world

        output = decryptCaesarCipher("nzop delepd dfaazced jzf", 11);
        System.out.println(output); // --> code states supports you
    }

    public static String decryptCaesarCipher(String str, int secret){
        char[] charArr = str.toCharArray();
        char[] newCharArr = new char[charArr.length];
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] != ' '){
                if((int)charArr[i] - secret < (int)'a') {
                    newCharArr[i] = (char)(charArr[i] - (char)(secret+48) + 48 + 26);
                } else {
                    newCharArr[i] = (char)(charArr[i] - (char)(secret+48) + 48);
                }
            } else {
                newCharArr[i] = ' ';
            }
        }

        return String.valueOf(newCharArr);
    }
}
