public class BasicAccount implements IAccount{

    private int accountNumber;
    private double withdrawLimit;
    private double currentBalance;

public BasicAccount(int accountNumber,double withdrawalLimit,double currentBalance){

    this.accountNumber = accountNumber;
    this.withdrawLimit = withdrawalLimit;
    this.currentBalance = currentBalance;
}

    public void setAccountNumber(int accountNumber) {
        this.accountNumber=accountNumber;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public void Deposit(double amount) {
    this.currentBalance = this.currentBalance + amount;

    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= this.withdrawLimit) {
            this.currentBalance = this.currentBalance - amount;
            return amount;}
        else{
            this.currentBalance = this.currentBalance - this.withdrawLimit;
            return this.withdrawLimit;
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


    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
