package day_1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("day_1/beans.xml");
        Account acc1 = context.getBean("account1", Account.class);

        System.out.println("Data of Account 1:");
        System.out.println("Id: "+ acc1.getId());
        System.out.println("Balance: " +acc1.getBalance());
        System.out.println("Ownername: " +acc1.getOwnerName());

    }
}