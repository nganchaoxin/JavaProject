package mvc.main;

import mvc.configuration.SpringConfig;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
    static OrderDetailsRepository orderDetailsRepository = context.getBean("orderDetailsRepository", OrderDetailsRepository.class);
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
