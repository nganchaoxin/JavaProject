package mvc.main;

import mvc.configuration.SpringConfig;
import mvc.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepositoryImpl = context.getBean("bookRepositoryImpl", BookRepository.class);

    public static void main(String[] args) {
        //System.out.println(bookRepositoryImpl.findAll());

    }
}
