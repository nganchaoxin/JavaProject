package mvc.controller.book;

import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.book.BookRepository;
import mvc.repository.book.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



@RestController

public class BookController {

    @Autowired
    BookRepository bookRepository;


    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Object showBook() {

        return bookRepository.findAll();
        //return "book/bookManagement";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("searchInput") String searchInput,
                         Model model) {
        List<BookEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = (List<BookEntity>) bookRepository.findAll();

        } else {
            resultList = bookRepository.findByNameContainingOrAuthorContaining(searchInput, searchInput);
        }

        model.addAttribute("bookList", resultList);

        return "book/bookManagement";
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public String newBook(Model model) {
        model.addAttribute("book", new BookEntity());
        // at the action do create new book with "/newBook" direction
        model.addAttribute("action", "newBook");

        setCategoryDropDownList(model);
        return "book/newBook";
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String saveBook(BookEntity book) {
        bookRepository.save(book);

        return "redirect:/book";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookRepository.findById(id));
        model.addAttribute("msg", "Update book information");
        // if the type === update show the id book
        model.addAttribute("type", "update");
        // at the action do "updateBook" with "/updateBook" direction
        model.addAttribute("action", "updateBook");

        setCategoryDropDownList(model);
        return "book/newBook";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute BookEntity book) {
        bookRepository.save(book);

        return "redirect:/book";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "redirect:/book";
    }

    private void setCategoryDropDownList(Model model) {
        List<CategoryEntity> cateList = (List<CategoryEntity>) categoryRepository.findAll();

        if (!cateList.isEmpty()) {
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for (CategoryEntity categoryEntity : cateList) {
                cateMap.put(categoryEntity.getId(), categoryEntity.getName());
            }
            model.addAttribute("categoryList", cateMap);
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
