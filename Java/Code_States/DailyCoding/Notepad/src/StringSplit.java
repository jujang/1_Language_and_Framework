public class StringSplit {
    public static void main(String args[]){

        String str = "abcd  id efg   hohoho";
        String[] out = str.split(" ");

        String str2 = "abcd  id efg   hohoho";
        String[] out2 = str.split("x");



        for(int i = 0; i < out2.length; i++){
            System.out.println(out2[i]);
        }
//        System.out.println(out[0]);
//        System.out.println(out[1]);
//        System.out.println(out[1]);
//        System.out.println(str.split("  "));


    }
}
