package service;

import entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AccountRepository;

import java.util.*;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(int sourceAccountId, int targetAccountId, double amount) throws Exception {
        AccountEntity sourceAccount = accountRepository.findById(sourceAccountId).get();
        AccountEntity targetAccount = accountRepository.findById(targetAccountId).get();

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        accountRepository.save(sourceAccount);

        if (sourceAccount.getBalance() < 0) {
            System.out.println(sourceAccount.getBalance());
            throw new Exception("amount to transfer than balance");
        }

        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountRepository.save(targetAccount);

    }

    // noRollbackFor NullEx means if field = null still update/insert
    @Transactional(noRollbackFor = NullPointerException.class)
    // rollbackFor NullEx means if field = null it will rollback and not update/insert table
    //@Transactional(rollbackFor = NullPointerException.class)
    public void updateAccount() throws NullPointerException {
        AccountEntity account1 = new AccountEntity();
        account1.setOwnerName("Clone");
        account1.setBalance(200);
        account1.setAccessTime(null);
        accountRepository.save(account1);

        if (account1.getAccessTime() == null) {
            System.out.println(account1.getAccessTime());
            throw new NullPointerException("field null, plz check again");
        }

        //accountRepository.updateAccount();

    }

    public void deleteAccount() {
        accountRepository.deleteAccount();
    }

    public void createNewAccount() {
        AccountEntity account1 = new AccountEntity();
        account1.setOwnerName("Alice");
        account1.setBalance(200);
        account1.setAccessTime(new Date());
        accountRepository.save(account1);

        AccountEntity account2 = new AccountEntity();
        account2.setOwnerName("Eric");
        account2.setBalance(100);
        account2.setAccessTime(new Date());
        accountRepository.save(account2);

    }

    public void listAllAccount() {
        List<AccountEntity> accountEntity = (List<AccountEntity>) accountRepository.findAll();
        System.out.println(accountEntity.toString());
    }

}
