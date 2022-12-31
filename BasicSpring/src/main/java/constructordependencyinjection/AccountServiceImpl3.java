package constructordependencyinjection;

import xmlbasedconfiguration.pojobeans.Account;
import xmlbasedconfiguration.pojobeans.AccountRepository;
import xmlbasedconfiguration.pojobeans.AccountService;

public class AccountServiceImpl3 implements AccountService {
    private AccountRepository accountRepository;
    // Constructor
    public AccountServiceImpl3(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transferMoney(long fromAccountId, long toAccountId, double amount) {
        Account sourceAccount = accountRepository.find(fromAccountId);
        Account targetAccount = accountRepository.find(toAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);

        accountRepository.update(sourceAccount);
        accountRepository.update(targetAccount);
    }

    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
        Account account = accountRepository.find(accountId);
        account.setBalance(account.getBalance() + amount);
        accountRepository.update(account);
    }

    @Override
    public Account getAccount(long AccountId) {
        return accountRepository.find(AccountId);
    }
}
