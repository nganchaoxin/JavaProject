package mvc.main;


import mvc.configuration.SpringConfig;
import mvc.entity.BookDetailsEntity;
import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import mvc.repository.book.BookRepository;
import mvc.repository.book.CategoryRepository;

import java.time.LocalDate;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
    static CategoryRepository categoryRepository = context.getBean("categoryRepository", CategoryRepository.class);

    public static void main(String[] args) {

        //bookRepository.findAll();
        createNewBookEntryWithNewCategory();
        createNewBookEntry();
        //createNewCategory();
        //createNewBook();
        //updateById(2);
    }

//    public static void updateById(int id) {
//        Optional<BookEntity> bookEntity = bookRepository.findById(id);
//
//        bookEntity.get().setName("Spring Boot");
//        BookDetailsEntity bookDetailsEntity = bookEntity.get().getBookDetails();
//        bookDetailsEntity.setPublicDate(LocalDate.now());
//        bookDetailsEntity.setPrice(50);
//
//        bookEntity.get().setBookDetails(bookDetailsEntity);
//        bookDetailsEntity.setBook(bookEntity.get());
//
//        bookRepository.save(bookEntity.get());
//        System.out.println(bookEntity.toString());
//    }
//
    public static void createNewBookEntryWithNewCategory() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }

    public static void createNewBookEntry() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);

        bookRepository.save(bookEntity);
    }
//
    public static BookEntity createNewBook() {
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("ISIBF1219323");
        bookDetailsEntity.setNumberOfPage(23);
        bookDetailsEntity.setPrice(65);
        bookDetailsEntity.setPublicDate(LocalDate.now());

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Java A-Z");
        bookEntity.setAuthor("Roger");

        // Set BoolDetail into Book
        bookEntity.setBookDetails(bookDetailsEntity);
        // Set Book into BookDetail
        bookDetailsEntity.setBook(bookEntity);

        return bookEntity;
    }
//
//    private static CategoryEntity createNewCategory() {
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryEntity.setName("IT");
//        categoryEntity.setDescription("IT books");
//        return categoryEntity;
//    }

}