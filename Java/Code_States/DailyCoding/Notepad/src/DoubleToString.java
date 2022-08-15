import java.util.*;

public class DoubleToString {
    public static void main(String[] args){

        String output = computeSquareRoot(6);
        System.out.println(output); // --> "3.00"

    }

    public static String computeSquareRoot(int num) {


//        double sqrtNum = Math.round(Math.sqrt(num)*100)/100.0;
//        String result = Double.toString(sqrtNum);
//
//        String formatString = sqrtNum
//        return result;

        double d;
        for(d = 0.00; d*d < num; d = d+0.001){}
        System.out.println(d);
//        double roundD = Math.round(d*100)/100.0;
        return String.format("%.2f", d);
    }

}
