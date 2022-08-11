public class AccountingMethodApp {
    public static double valueOfSupply = 22000.0;
    public static double vatRate = 0.1;
    public static double expenseRate = 0.3;

    public static void main(String[] args){

        double vat = getVat();
        double total = getTotal();
        double expense = getExpense();
        double income = getIncome();
        double dividend1 = getDividend1();
        double dividend2 = getDividend2();
        double dividend3 = getDividend3();

        print();
    }

    private static void print() {
        System.out.println("Value of supply: "+ valueOfSupply);
        System.out.println("Vat: "+ getVat());
        System.out.println("Total : "+ (valueOfSupply + getVat()));
        System.out.println("Expense : "+ getExpense());
        System.out.println("Income : "+ getIncome());
        System.out.println("Dividend 1 : "+ getDividend1());
        System.out.println("Dividend 2 : "+ getDividend2());
        System.out.println("Dividend 3 : "+ getDividend3());
    }

    private static double getDividend1() {
        return getIncome() * 0.5;
    }
    private static double getDividend2() {
        return getIncome() * 0.3;
    }
    private static double getDividend3() {
        return getIncome() * 0.2;
    }

    private static double getIncome() {
        return valueOfSupply - getExpense();
    }

    private static double getExpense() {
        return valueOfSupply * expenseRate;
    }

    private static double getTotal() {
        return valueOfSupply * getVat();
    }

    private static double getVat() {
        return valueOfSupply * vatRate;
    }
}
