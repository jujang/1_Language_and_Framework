public class Q23_fibonacci {
    public static void main(String[] args) {

        int output = fibonacci(0);
        System.out.println(output); // --> 0

        output = fibonacci(1);
        System.out.println(output); // --> 1

        output = fibonacci(5);
        System.out.println(output); // --> 5

        output = fibonacci(9);
        System.out.println(output); // --> 34

    }

    public static int fibonacci(int num) {
        // TODO:

        int[] f = new int[1000];

        f[0] = 0;
        f[1] = 1;

        return fiborecursion(num, f);

//        if(num == 0) return 0;
//        else if(num == 1) return 1;
//
//        return fibonacci(num-1) + fibonacci(num-2);

    }

    public static int fiborecursion(int num, int[] f){

        if(num == 0) return 0;
        else if(num == 1) return 1;

        if(f[num] == 0){
            f[num] = fiborecursion(num-2, f) + fiborecursion(num-1, f);
        }
        return f[num];
    }
}
