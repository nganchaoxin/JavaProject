package mvc.controller;

import mvc.entity.ProductEntity;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value="/product", method = RequestMethod.GET)
    public String showProduct(Model model) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("productList", productList);

        return "shoppingcart/productList";
    }
}
