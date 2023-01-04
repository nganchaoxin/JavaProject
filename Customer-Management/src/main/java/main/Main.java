package main;

import configuration.JPAconfig;
import entity.CustomerEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepository;
import service.CustomerService;


import java.time.LocalDate;
import java.util.List;


public class Main {
    //      static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAconfig.class);
//    static CustomerRepository customerRepository = applicationContext.getBean("customerRepository", CustomerRepository.class);
    public static void main(String[] args) {
//        CustomerService.addCustomer();
//        CustomerService.listAllCustomer();
//        CustomerService.findById();
//        CustomerService.findByStartName();
//        CustomerService.findByPhone();
//        CustomerService.findByEmail();
//        CustomerService.findMenByAge();
        CustomerService.findByPhoneOrEmail();
    }
}
