public class Q25_power {
    public static void main(String[] args){

        long output = power(3, 40);
        System.out.println(output); // --> 19334827


        output = power(1949062514, 51);
        System.out.println(output); // --> 26674659

        output = power_logN(1949062514, 51);
        System.out.println(output); // --> 26674659
    }

    public static long power (int base, int exponent) {

        long rest = base;

        for(int i = 1; i < exponent; i++){
//            rest = rest * base % 94906249;
            rest = rest * base % 59;
        }

        return rest;
    }

    public static long power_logN (int base, int exponent) {

        if(exponent == 0) return 1;

        long temp = power_logN(base, exponent/2);

        long result = (temp * temp) % 94906249;

        if(exponent % 2 == 1) return (base * result) % 94906249;
        else return result;
    }
}
