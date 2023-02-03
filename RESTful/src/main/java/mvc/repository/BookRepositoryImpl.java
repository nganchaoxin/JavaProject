package mvc.repository;

import mvc.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookRepositoryImpl {
    @Autowired
    BookRepository bookRepository;


    public BookEntity update(BookEntity newBookData) {
        boolean isFound = false;
        BookEntity foundBook = null;

        List<BookEntity> bookList = (List<BookEntity>) bookRepository.findAll();

        // found id book in data to replace
        for (BookEntity book : bookList) {
            if (book.getId() == newBookData.getId()) {
                isFound = true;
                foundBook = book;
                break;
            }
        }
        // if can not found id book
        if (!isFound) {
            return null;
        }
        // remove old data book to add new data book
        bookList.remove(foundBook);
        newBookData.setId(foundBook.getId());
        bookList.add(newBookData);

        return newBookData;
    }

    public boolean delete(int bookID) {
        boolean isFound = false;
        BookEntity foundBook = null;

        for(BookEntity book: bookRepository.findAll()){
            if (book.getId() == bookID) {
                isFound = true;
                foundBook = book;
                break;
            }
        }
        if (!isFound) {
            return false;
        }

        bookRepository.deleteById(bookID);
        return true;
    }

}
