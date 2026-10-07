import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
       
        SavingsAccount sa = new SavingsAccount("SA-101", 500.00, 100.00, 0.05);
        CurrentAccount ca = new CurrentAccount("CA-201", 200.00, 300.00, 15.00);

        System.out.println("=== Edge Case Demonstrations ===");
        
        System.out.println("\n--- Test 1: SavingsAccount Rejection ---");
        sa.withdraw(450.00);

        System.out.println("\n--- Test 2: CurrentAccount Overdraft ---");
        ca.withdraw(350.00);

        System.out.println("\n=== Polymorphic Loop Demonstration ===");
        
        List<Account> accounts = new ArrayList<>();
        accounts.add(sa);
        accounts.add(ca);

        for (Account acc : accounts) {
            System.out.println("\nProcessing Account ID: " + acc.getAccountNumber());
            acc.withdraw(50.00);
            acc.endOfMonth();
        }
    }
}