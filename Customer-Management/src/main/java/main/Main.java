package main;

import configuration.JPAconfig;
import entity.CustomerEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepository;


import java.time.LocalDate;
import java.util.List;


public class Main {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAconfig.class);
    static CustomerRepository customerRepository = applicationContext.getBean("customerRepository", CustomerRepository.class);

    public static void main(String[] args) {
//        addCustomer();
        listAllCustomer();
//        findById();
//        findByStartName();
//        findByPhone();
//        findByEmail();
//        findMenByAge();
    }

    public static void addCustomer() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Pham Le Kim Ngan");
        customerEntity.setBirthDate(LocalDate.parse("2001-12-07"));
        customerEntity.setSex("female");
        customerEntity.setEmail("kimnganpham@gmail.com");
        customerEntity.setPhone(123);
        customerEntity.setAddress("somewhere");
        CustomerEntity result = customerRepository.save(customerEntity);
        if (result != null) {
            System.out.println("A new customer saved successfully, customer ID = " + customerEntity.getId());
        }
    }

    public static void listAllCustomer() {
        System.out.println(customerRepository.findAll());
    }

    public static void findById() {
        System.out.println(customerRepository.findById(2));

    }

    public static void findByStartName() {
        System.out.println(customerRepository.findByStartName("N"));
    }

    public static void findByPhone() {
        System.out.println(customerRepository.findByPhone(123));
    }

    public static void findByEmail() {
        System.out.println(customerRepository.findByEmail("kimnganpham@gmail.com"));
    }

    public static void findMenByAge() {
        System.out.println(customerRepository.listMen());
    }


}