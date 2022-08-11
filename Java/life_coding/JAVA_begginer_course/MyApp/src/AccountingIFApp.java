public class AccountingIFApp {
    public static void main(String[] args){

        double valueOfSupply = 5000.0;
//        double valueOfSupply = Double.parseDouble(args[0]);
        double vatRate = 0.1;
        double vat = valueOfSupply * vatRate;
        double expenseRate = 0.3;
        double expense = valueOfSupply * expenseRate;
        double income = valueOfSupply - expense;

        double[] dividendRates = {0.5, 0.3, 0.2};

        double dividend1;
        double dividend2;
        double dividend3;

        if(income > 10000) {
            dividend1 = income * dividendRates[0];
            dividend2 = income * dividendRates[1];
            dividend3 = income * dividendRates[2];
        } else {
            dividend1 = income * 1.0;
            dividend2 = income * 0;
            dividend3 = income * 0;
        }


        System.out.println("Value of supply: "+ valueOfSupply);
        System.out.println("Vat: "+ vat);
        System.out.println("Total : "+ (valueOfSupply + vat));
        System.out.println("Expense : "+ expense);
        System.out.println("Income : "+ income);

        System.out.println("Dividend 1 : "+ dividend1);
        System.out.println("Dividend 2 : "+ dividend2);
        System.out.println("Dividend 3 : "+ dividend3);

    }
}
