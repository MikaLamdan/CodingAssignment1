public class StandardAccount implements IAccount{
    private int accountNumber;
    private double creditLimit;
    private double currentBalance;
public StandardAccount(int accountNumber, double creditLimit,double currentBalance) {

    this.accountNumber = accountNumber;
    this.creditLimit = creditLimit;
    this.currentBalance = currentBalance;
}

    @Override
    public void Deposit(double amount) {
    this.currentBalance = this.currentBalance + amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= this.currentBalance) {
            this.currentBalance = this.currentBalance - amount;
            return amount;
        } else {
            this.currentBalance = this.currentBalance - this.currentBalance + Math.abs(this.creditLimit);
            return this.currentBalance + Math.abs(this.creditLimit);
        }
    }


    @Override
    public double GetCurrentBalance() {
        return this.currentBalance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }


    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }


    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
