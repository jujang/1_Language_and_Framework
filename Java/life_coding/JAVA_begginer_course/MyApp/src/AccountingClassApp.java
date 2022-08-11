class Accounting{
    public double valueOfSupply = 22000.0;
    public double vatRate = 0.1;
    public double expenseRate = 0.3;

    public void print() {
        System.out.println("Value of supply: "+ valueOfSupply);
        System.out.println("Vat: "+ getVat());
        System.out.println("Total : "+ (valueOfSupply + getVat()));
        System.out.println("Expense : "+ getExpense());
        System.out.println("Income : "+ getIncome());
        System.out.println("Dividend 1 : "+ getDividend1());
        System.out.println("Dividend 2 : "+ getDividend2());
        System.out.println("Dividend 3 : "+ getDividend3());
    }

    double vat = getVat();
    double total = getTotal();
    double expense = getExpense();
    double income = getIncome();
    double dividend1 = getDividend1();
    double dividend2 = getDividend2();
    double dividend3 = getDividend3();


    private double getDividend1() {
        return getIncome() * 0.5;
    }
    private double getDividend2() {
        return getIncome() * 0.3;
    }
    private double getDividend3() {
        return getIncome() * 0.2;
    }

    private double getIncome() {
        return valueOfSupply - getExpense();
    }

    private double getExpense() {
        return valueOfSupply * expenseRate;
    }

    private double getTotal() {
        return valueOfSupply * getVat();
    }

    private double getVat() {
        return valueOfSupply * vatRate;
    }

}



public class AccountingClassApp {
    public static void main(String[] args){
//        Accounting.valueOfSupply = 10000.0;
//        Accounting.vatRate = 10000.0;
//        Accounting.expenseRate = 10000.0;
//        Accounting.print();

        //instance
        Accounting a1 = new Accounting();
        a1.valueOfSupply = 10000.0;
        a1.vatRate = 0.1;
        a1.expenseRate = 0.3;
        a1.print();

        Accounting a2 = new Accounting();
        a2.valueOfSupply = 20000.0;
        a2.vatRate = 0.05;
        a2.expenseRate = 0.2;
        a2.print();
    }
}
