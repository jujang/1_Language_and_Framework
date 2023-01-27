public class Q28_balancedBrakets {
    public static void main(String[] args) {

        boolean output = balancedBrackets("(");
        System.out.println(output); // // -> false

        output = balancedBrackets("()");
        System.out.println(output); // --> true

        boolean output1 = balancedBrackets("[](){}");
        System.out.println(output1); // --> true

        boolean output2 = balancedBrackets("[({})]");
        System.out.println(output2); // --> true

        boolean output3 = balancedBrackets("[(]{)}");
        System.out.println(output3); // --> false

    }

    public static boolean balancedBrackets(String str) {
        // TODO:

        int bracket1 = 0;
        int bracket2 = 0;
        int bracket3 = 0;

        for(int i = 0; i < str.length(); i++){
            switch (str.charAt(i)){
                case '[':
                    bracket1++;
                    break;
                case ']':
                    bracket1--;
                    break;
                case '{':
                    bracket2++;
                    break;
                case '}':
                    bracket2--;
                    break;
                case '(':
                    bracket3++;
                    break;
                case ')':
                    bracket3--;
                    break;
            }
            if( bracket1 < 0 || bracket2 < 0 || bracket3 < 0) return false;
        }

        boolean result = (bracket1 == 0) && (bracket2 == 0) && (bracket3 == 0);
        return result;
    }

}
