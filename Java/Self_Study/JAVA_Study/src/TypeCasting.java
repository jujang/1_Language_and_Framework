public class TypeCasting {
    public static void main(String[] args){

        double var1 = 1.1;
        int var2 = 2;
        int var3;
        var3 = (int)var1 + var2;

        System.out.println(var3);

        char car1 = 'a';
        char car2 = 'b';
        String str = String.valueOf(car1) + String.valueOf(car2);

        System.out.println(str);

    }
}
