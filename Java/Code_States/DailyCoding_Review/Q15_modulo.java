public class Q15_modulo {
    public static void main(String[] args){
        Integer output = modulo(25, 4);
        System.out.println(output); // --> 1

        output = modulo(25, 0);
        System.out.println(output); // --> null
    }
    public static Integer modulo(int num1, int num2){

        if(num1 == 0) return 0;
        if(num2 == 0) return null;

        int remains = num1;
        while(remains >= num2){
            remains -= num2;
        }

        return remains;
    }
}
