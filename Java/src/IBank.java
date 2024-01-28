import java.util.*;
public interface IBank {
void OpenACCOUNT(IAccount account);
void CloseAccount(int accountNumber);
List<IAccount> GetAllAccounts();
List<IAccount> GetAllAccountsInDebt();
List<IAccount> GetAllAccountsWithBalance(double balanceAbove);
}
