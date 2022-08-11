class Accounting{
    public double valueOfSupply;
    public double vatRate = 0.1;

    public Accounting(double valueOfSupply) {
        this.valueOfSupply = valueOfSupply;
    }
    public double getVAT(){
        return valueOfSupply * vatRate;
    }
    public double getTotal(){
        return valueOfSupply + getVAT();
    }
}

public class AccountingApp {
    public static void main(String[] args) {
        Accounting case1 = new Accounting(10000.0);
        Accounting case2 = new Accounting(20000.0);

        System.out.println("case1/ Value of supply : " + case1.valueOfSupply);
        System.out.println("case2/ Value of supply : " + case2.valueOfSupply);

        System.out.println("case1/ VAT: " + case1.getVAT());
        System.out.println("case2/ VAT: " + case2.getVAT());

        System.out.println("case1/ Total : " + case1.getTotal());
        System.out.println("case2/ Total : " + case2.getTotal());

    }
}
