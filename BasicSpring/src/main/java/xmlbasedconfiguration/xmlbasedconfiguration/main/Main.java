package xmlbasedconfiguration.xmlbasedconfiguration.main;

import xmlbasedconfiguration.pojobeans.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlbasedconfiguration/beans.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println("Data of Account 1:" + accountService.getAccount(1).getBalance());


    }

}
