public class BitOperatior {
    public static void main(String[] args) {

        int a = 5;
        int b = 5;
        int b_1 = ~b;

//        System.out.println(b_1);
//        System.out.println(~a);

//        System.out.println(~a ^ b);


        System.out.println(7 & 0);
        System.out.println(7 | 0);
        System.out.println(7 ^ 0);
        System.out.println("-----");

        System.out.println(7 & 1);
        System.out.println(7 | 1);
        System.out.println(7 ^ 1);
        System.out.println("-----");

        System.out.println(7 & 2);
        System.out.println(7 | 2);
        System.out.println(7 ^ 2);


        String str = "abc";
        System.out.println(Math.pow(2, str.length()));
    }
}
