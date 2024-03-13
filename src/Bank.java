import java.util.*;

public class Bank implements IBank {
    private List<IAccount> allAccounts;

    public Bank() {
        this.allAccounts = new ArrayList<IAccount>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        this.allAccounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (IAccount account : this.allAccounts) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) //We also considered the case where the balance equals 0.
                {
                    this.allAccounts.remove(account);
                } else {
                    System.out.println("Account is not closed due to debt.");
                }
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return this.allAccounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> negativeAccounts = new ArrayList<>();
        for (IAccount account : this.allAccounts) {
            if (account.GetCurrentBalance() < 0) {
                negativeAccounts.add(account);
            }
        }
        return negativeAccounts;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> positiveAccounts = new ArrayList<>();
        for (IAccount account : this.allAccounts) {
            if (account.GetCurrentBalance() > 0) {
                positiveAccounts.add(account);
            }
        }
        return positiveAccounts;
    }
}

