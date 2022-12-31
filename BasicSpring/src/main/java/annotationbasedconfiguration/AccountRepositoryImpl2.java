package annotationbasedconfiguration;

import xmlbasedconfiguration.pojobeans.Account;
import xmlbasedconfiguration.pojobeans.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class AccountRepositoryImpl2 implements AccountRepository {

    private Map<Long, Account> accountsMap = new HashMap<>();

    {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setOwnername("Ngan");
        account1.setBalance(10.0);

        Account account2 = new Account();
        account2.setId(1L);
        account2.setOwnername("Ly");
        account2.setBalance(10.0);

        accountsMap.put(account1.getId(), account1);
        accountsMap.put(account2.getId(), account2);
    }
    @Override
    public void insert(Account account) {

    }

    @Override
    public void update(Account account) {

    }

    @Override
    public Account find(long accountId) {
        return accountsMap.get(accountId);
    }
}
