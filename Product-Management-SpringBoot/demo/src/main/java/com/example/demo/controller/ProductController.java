package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.service.ProductService;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value={"/","/products"})
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "product";
    }

}
