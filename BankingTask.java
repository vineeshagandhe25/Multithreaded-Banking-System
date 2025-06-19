public class BankingTask implements Runnable {
    private Account from;
    private Account to;
    private double amount;

    public BankingTask(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        from.transfer(to, amount);
    }
}
