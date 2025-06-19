public class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accNo, String name, double initialBalance) {
        this.accountNumber = accNo;
        this.accountHolder = name;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited " + amount);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }

    public synchronized void transfer(Account target, double amount) {
        if (balance >= amount) {
            this.withdraw(amount);
            target.deposit(amount);
            System.out.println(accountHolder + " transferred " + amount + " to " + target.accountHolder);
        } else {
            System.out.println("Transfer failed: insufficient funds for " + accountHolder);
        }
    }

    public double getBalance() {
        return balance;
    }
}
