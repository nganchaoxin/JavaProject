package mvc.main;

import mvc.configuration.SpringConfig;
import mvc.entity.OrderDetailsEntity;
import mvc.entity.OrdersEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
    static OrderDetailsRepository orderDetailsRepository = context.getBean("orderDetailsRepository", OrderDetailsRepository.class);
    public static void main(String[] args) {
        //createNewProduct();
    }
    public static ProductEntity createNewProduct() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("Chair");
        productEntity.setPrice(250.0);
        productEntity.setProductDescription("Something to sit");

        productRepository.save(productEntity);
        return productEntity;
    }
}
