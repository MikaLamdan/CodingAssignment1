public class StandardAccount implements IAccount {
    private int accountNumber;
    private double creditLimit;
    private double currentBalance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = Math.min(creditLimit, 0);
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

        amount = Math.min(amount, this.currentBalance - this.creditLimit);
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
