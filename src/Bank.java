import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> allAccounts;

    public Bank() {
        this.allAccounts = new ArrayList<IAccount>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        this.allAccounts.add(account);
    }

    private IAccount GetAccount(int accountNumber) {
        for (IAccount account : this.allAccounts) {
            if (account.GetAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount account = this.GetAccount(accountNumber);
        if (account == null) {
            return;
        }

        if (account.GetCurrentBalance() >= 0) {
            this.allAccounts.remove(account);
        } else {
            System.out.println("Account is not closed due to debt.");
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
