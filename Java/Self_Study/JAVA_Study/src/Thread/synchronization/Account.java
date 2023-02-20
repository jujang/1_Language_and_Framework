package Thread.synchronization;

public class Account {
    private int balance = 1000;

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            balance -= money;
        } // withdraw
    }
}