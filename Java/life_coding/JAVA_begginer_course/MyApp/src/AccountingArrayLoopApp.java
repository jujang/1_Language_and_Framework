public class AccountingArrayLoopApp {
    public static void main(String[] args){

        double valueOfSupply = 10000.0;
        double vatRate = 0.1;
        double vat = valueOfSupply * vatRate;
        double expenseRate = 0.3;
        double expense = valueOfSupply * expenseRate;
        double income = valueOfSupply - expense;

        System.out.println("Value of supply: "+ valueOfSupply);
        System.out.println("Vat: "+ vat);
        System.out.println("Total : "+ (valueOfSupply + vat));
        System.out.println("Expense : "+ expense);
        System.out.println("Income : "+ income);

        double[] dividendRates = {0.5, 0.3, 0.2};

        int i = 0;
        while(i < dividendRates.length) {
            System.out.println("Dividend : "+ dividendRates[i]);
            i++;
        }

    }
}
