public class ArraySplit {
    public static void main(String[] args){

        String str = "ababcabcdabcde";
        String[] words = str.split("a");
        System.out.println(words);

        for(int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }

        String result = String.join("1", words);

        System.out.println(result);
    }
}
