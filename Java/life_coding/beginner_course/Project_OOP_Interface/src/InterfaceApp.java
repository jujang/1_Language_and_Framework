interface Calculatable{
    int sum(int v1, int v2);
}
interface Printable{
    void print();
}
class RealCal implements Calculatable, Printable {
    public int sum(int v1, int v2) {
        System.out.println(v1 + v2);
        return v1+v2;
    }
    public void print(){
        System.out.println("This is RealCal!!");
    }
}
class AdvancedPrint implements Printable {
    public void print(){
        System.out.println("This is AdvancedPrint!!");
    }
}

public class InterfaceApp {
    public static void main(String[] args){
//        Printable c = new RealCal();
//        System.out.println(c.sum(2,1)); // error
//        c.print();

        RealCal test = new RealCal();
        test.sum(20, 20);
        test.print();

        Calculatable test_3 = new RealCal();
        test_3.sum(20, 20);

        Printable test2 = new AdvancedPrint();
        test2.print();
    }
}