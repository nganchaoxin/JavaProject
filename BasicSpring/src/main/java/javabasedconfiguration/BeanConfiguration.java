package javabasedconfiguration;

import org.springframework.context.annotation.Configuration;
import xmlbasedconfiguration.pojobeans.AccountRepository;
import xmlbasedconfiguration.pojobeans.AccountRepositoryImpl;
import xmlbasedconfiguration.pojobeans.AccountService;
import xmlbasedconfiguration.pojobeans.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
@Configuration
public class BeanConfiguration {
    @Bean
    public AccountService accountService(){
        AccountServiceImpl bean = new AccountServiceImpl();
        bean.setAccountRepository(accountRepository());
        return bean;
    }
    @Bean
    public AccountRepository accountRepository() {
        AccountRepositoryImpl bean= new AccountRepositoryImpl();
        return bean;
    }
}
