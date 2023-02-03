package mvc.controller;

import mvc.entity.BookEntity;
import mvc.repository.BookRepository;
import mvc.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookRepositoryImpl bookRepositoryImpl;

    // GET show all books
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object showAllBook(Model model) {
        List<BookEntity> bookList = (List<BookEntity>) bookRepository.findAll();
        model.addAttribute("bookList", bookList);
        return bookList;
    }

    // POST add a new data book
    @RequestMapping(method = RequestMethod.POST)
    public Object addNewBook(@RequestBody BookEntity newBookEntity) {
        BookEntity result = bookRepository.save(newBookEntity);
        return result;
    }

    // PUT update books by id
    @RequestMapping(method = RequestMethod.PUT)
    public Object updateBook(@RequestBody BookEntity updatedBookEntity) {
        BookEntity result = bookRepositoryImpl.update(updatedBookEntity);

        if (result == null) {
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", updatedBookEntity.getId() + " does not exist");
            }};
            return error;
        }
        return bookRepository.save(result);
    }

    // DELETE delete books by id
    @RequestMapping(value = "/{bookID}", method = RequestMethod.DELETE)
    public Object deleteBook(@PathVariable(value = "bookID") String bookID) {
        Boolean result = bookRepositoryImpl.delete(Integer.valueOf(bookID));

        if (!result) {
            Map<String, String> error = new HashMap<String, String>() {{
                put("error", "A book wich book ID = " + bookID + " doesn't exist");
            }};
            return error;
        } else {
            Map<String, String> success = new HashMap<String, String>() {{
                put("success", "A book wich book ID = " + bookID + " has been deleted successfully!");
            }};
            return success;
        }

    }

    // GET search books
    @RequestMapping(value = "/search/{searchInput}", method = RequestMethod.GET)
    public List<BookEntity> search(@PathVariable(value = "searchInput") String searchInput, Model model) {
        List<BookEntity> resultList;
        resultList = bookRepository.findByNameContainingOrAuthorContaining(searchInput, searchInput);

        model.addAttribute("bookList", resultList);
        return resultList;
    }

}
