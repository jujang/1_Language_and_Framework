public class numberSearch {
    public static void main(String[] args){

        int output = numberSearch("Hello6 ");
        System.out.println(output); // --> 1

        output = numberSearch("Hello6 9World 2,");
        System.out.println(output); // --> 2

        output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println(output); // --> 2
    }

    public static int numberSearch(String str){

        int sum = 0;
        int charCnt = 0;
        String convertStr = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            if(Character.isLowerCase(convertStr.charAt(i))) charCnt++;
            else if(Character.isDigit(convertStr.charAt(i))) {
                sum += (int)(convertStr.charAt(i)) - (int)('0');
            }
        }

        int result = Math.round((float)sum/(float)charCnt);
        return result;
    }
}
