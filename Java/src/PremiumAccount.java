public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double currentBalance;

    public PremiumAccount(int accountNumber,double currentBalance){

        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    @Override
    public void Deposit(double amount) {
        this.currentBalance = this.currentBalance + amount;

    }

    @Override
    public double Withdraw(double amount) {
     this.currentBalance = this.currentBalance - amount;
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


    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
