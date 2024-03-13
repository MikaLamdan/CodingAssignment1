public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double currentBalance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.currentBalance = 0;
    }

    @Override
    public void Deposit(double amount) {
        if (amount > 0) {
            this.currentBalance += amount;
        }
    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= 0) {
            return 0;
        }

        this.currentBalance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return this.currentBalance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }

}
