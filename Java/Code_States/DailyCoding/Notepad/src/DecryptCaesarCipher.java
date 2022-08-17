public class DecryptCaesarCipher {
    public static void main(String[] args){

        String output = decryptCaesarCipher("khoor", 3);
        System.out.println(output); // --> hello

        output = decryptCaesarCipher("zruog", 3);
        System.out.println(output); // --> world

        output = decryptCaesarCipher("mnv xnt zqd qdzcx sn lnud sn hlldqrhud bntqrd", 25);
        System.out.println(output); // --> world

    }

    public static String decryptCaesarCipher(String str, int secret) {

        if(str.length() == 0) return str;

        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ') newStr += str.charAt(i);
            else {
                if(str.charAt(i) - secret < (int)'a') newStr += (char)(str.charAt(i) + 26 - secret);
                else newStr += (char)(str.charAt(i) - secret);
            }
        }

        return newStr;
    }
}
