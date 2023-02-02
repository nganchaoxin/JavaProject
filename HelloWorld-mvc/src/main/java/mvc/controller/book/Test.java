package mvc.controller.book;

import mvc.entity.BookEntityDemo;
import mvc.repository.book.BookDemoRepository;
import mvc.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test {
    @Autowired
    BookDemoRepository bookRepository;

    @RequestMapping(value = "/book1", method = RequestMethod.GET)
    public Object showBook() {
        List<BookEntityDemo> demoList = (List<BookEntityDemo>) bookRepository.findAll();
        return demoList;
        //return "book/bookManagement";
    }
}
