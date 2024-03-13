public class BasicAccount implements IAccount {
    private int accountNumber;
    private double withdrawLimit;
    private double currentBalance;

    public BasicAccount (int accountNumber, double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.withdrawLimit = withdrawLimit;
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

        amount = Math.min(Math.min(amount, this.withdrawLimit), this.currentBalance);
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
