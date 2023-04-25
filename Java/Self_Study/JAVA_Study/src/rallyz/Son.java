package rallyz;

public class Son extends Dad{
    public Son(String str, int a){
        super(str, a);
    }

    public void printSon() {
        System.out.println("I'm Son!!!");
//            System.out.println(super.str);
        super.printDad();
    }


}
