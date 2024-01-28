import java.util.*;
public class TheBank implements IBank {
    private List<IAccount> allAccounts;

    public TheBank() {
        this.allAccounts = new ArrayList<IAccount>();
    }
    @Override
    public void OpenACCOUNT(IAccount account) {
        allAccounts.add(account);

    }

    @Override
    public void CloseAccount(int accountNumber) {
        Iterator<IAccount> iterator = allAccounts.iterator();

        while (iterator.hasNext()) {
            IAccount account = iterator.next();

            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) {
                    iterator.remove();
                } else {
                    System.out.println("Account not closed due to debt.");
                }
                return; // Exit the method once you find the account
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(allAccounts);
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();

        for (IAccount account : allAccounts) {
            if (account.GetCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }

        return accountsInDebt;
    }


    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalanceAbove = new ArrayList<>();

        for (IAccount account : allAccounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithBalanceAbove.add(account);
            }
        }

        return accountsWithBalanceAbove;
    }
}
