import configuration.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.AccountService;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static AccountService accountService = context.getBean("accountService", AccountService.class);

    public static void main(String[] args) throws Exception {
        //accountService.createNewAccount();
        //accountService.transferMoney(1,5,100);
        //accountService.listAllAccount();
        accountService.updateAccount();
        //accountService.deleteAccount();
    }

}