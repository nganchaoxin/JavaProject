package javabasedconfiguration;

import xmlbasedconfiguration.pojobeans.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println("Data of Account 1:" + accountService.getAccount(1).getBalance());


    }
}
