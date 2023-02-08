package com.example.demo.controller;


import com.example.demo.entities.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value={"/","/products"})
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "product";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("searchInput") String searchInput,
                         @RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "3") int size,
                         Model model) {
        // Pageable
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> searchList;

        if (searchInput.isEmpty()) {
            searchList = (Page<ProductEntity>) productService.getProducts();

        } else {
            searchList = productService.getProductsByName(searchInput,pageable);
        }

        model.addAttribute("products", searchList);
        model.addAttribute("searchInput", searchInput);

        return "product";
    }

}
