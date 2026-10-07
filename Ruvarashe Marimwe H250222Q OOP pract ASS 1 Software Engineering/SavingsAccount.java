public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate; // e.g., 0.05 for 5%

    public SavingsAccount(String accountNumber, double balance, double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be positive.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.printf("REJECTED: Withdrawal of $%.2f from %s would violate minimum balance of $%.2f (Current balance: $%.2f)%n",
                    amount, accountNumber, minimumBalance, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrew $%.2f from %s. New balance: $%.2f%n", amount, accountNumber, balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("Savings Account %s: Applied interest rate of %.1f%% (+ $%.2f). New balance: $%.2f%n",
                accountNumber, interestRate * 100, interest, balance);
    }
}
