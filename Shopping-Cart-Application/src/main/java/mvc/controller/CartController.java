package mvc.controller;

import mvc.entity.CartEntity;
import mvc.entity.ProductEntity;
import mvc.repository.ProductRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@Controller
public class CartController {

//    @Autowired
//    CartEntity cartEntity;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value="/addToCart/{id}", method = RequestMethod.GET)
    public String addToCart(Model model, @PathVariable int id) {
        model.addAttribute("productInCart",productRepository.findById(id) );
//        CartEntity cart = new CartEntity();
//        cart.setOrdersEntity();
        return "shoppingcart/cart";
    }

}
