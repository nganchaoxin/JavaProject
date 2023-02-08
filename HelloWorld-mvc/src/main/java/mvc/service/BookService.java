package mvc.service;

import mvc.entity.BookEntity;
import mvc.repository.book.BookRepository;
import mvc.repository.book.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<BookEntity> findByNameContainingOrAuthorContaining(String searchInput, String searchInput1) {
        return bookRepository.findByNameContainingOrAuthorContaining(searchInput, searchInput1);
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public void save(BookEntity book) {
        bookRepository.save(book);
    }

}
