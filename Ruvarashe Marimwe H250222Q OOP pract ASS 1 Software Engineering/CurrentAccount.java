public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double maintenanceFee;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit, double maintenanceFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.printf("REJECTED: Withdrawal of $%.2f from %s exceeds overdraft limit of $%.2f (Current balance: $%.2f)%n",
                    amount, accountNumber, overdraftLimit, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrew $%.2f from %s. New balance: $%.2f%n", amount, accountNumber, balance);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= maintenanceFee;
        System.out.printf("Current Account %s: Deducted monthly maintenance fee (- $%.2f). New balance: $%.2f%n",
                accountNumber, maintenanceFee, balance);
    }
}
