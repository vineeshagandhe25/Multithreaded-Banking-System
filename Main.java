import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Account acc1 = new Account(101, "Alice", 1000);
        Account acc2 = new Account(102, "Bob", 500);
        Account acc3 = new Account(103, "Charlie", 800);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new BankingTask(acc1, acc2, 300));
        executor.submit(new BankingTask(acc2, acc3, 200));
        executor.submit(() -> acc1.deposit(500));
        executor.submit(() -> acc2.withdraw(100));
        executor.submit(() -> acc3.withdraw(900)); 

        executor.shutdown();
    }
}
