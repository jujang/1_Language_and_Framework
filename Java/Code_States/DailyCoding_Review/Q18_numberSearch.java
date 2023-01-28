public class Q18_numberSearch {
    public static void main(String[] args) {
        int output = numberSearch("Hello6 ");
        System.out.println(output); // --> 1

        System.out.println("--------------------------------------------");

        output = numberSearch("Hello6 9World 2,");
        System.out.println(output); // --> 2

        System.out.println("--------------------------------------------");

        output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println(output); // --> 2

        System.out.println("--------------------------------------------");
    }
    public static int numberSearch(String str){

        if(str.length() == 0) return 0;

        char[] charArr = str.toCharArray();
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(charArr[i] - '0' >= 1 && charArr[i] - '0' <= 9){
                sum += (charArr[i] - '0');
            } else {
                if(charArr[i] - '0' != -16){
                    cnt++;
                }
            }
        }

        return Integer.parseInt(String.format("%.0f", (double)sum/(double)cnt));
    }

}
