package constructordependencyinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlbasedconfiguration.pojobeans.AccountService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructordependencyinjection/beans.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println("Data of Account 1:" + accountService.getAccount(1).getBalance());


    }
}
