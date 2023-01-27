package mvc.controller;

import mvc.entity.CartEntity;
import mvc.entity.ProductEntity;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CartController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/myCart", method = RequestMethod.GET)
    public String showCartList(Model model, HttpSession session) {
        List<CartEntity> cartList = (List<CartEntity>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
            model.addAttribute("cartList", cartList);
        }

        return "shoppingcart/cart";
    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addToCart(Model model, @PathVariable int id, HttpServletRequest request) {
        List<CartEntity> cartList = (List<CartEntity>) request.getSession().getAttribute("cartList");

        // Find product by id and add to temp cart
        Optional<ProductEntity> optionalEntity = productRepository.findById(id);

        ProductEntity product = new ProductEntity();
        product.setName(optionalEntity.get().getName());
        product.setId(optionalEntity.get().getId());
        product.setPrice(optionalEntity.get().getPrice());
        product.setProductDescription(optionalEntity.get().getProductDescription());

        CartEntity cartTemp = new CartEntity();
        cartTemp.setProduct(product);
        cartTemp.setQuantity(1);

        // Init Cart and count quantity if it exists
        if (cartList == null) {
            cartList = new ArrayList<CartEntity>();
            cartList.add(cartTemp);

            request.getSession().setAttribute("cartList", cartList);
        } else {
            int index = this.exists(id, cartList);

            // Not exist
            if (index == -1) {
                cartList.add(cartTemp);
            }
            // Exist
            else {
                int quantity = cartList.get(index).getQuantity() + 1;
                cartList.get(index).setQuantity(quantity);
            }

            request.getSession().setAttribute("cartList", cartList);
        }

        model.addAttribute("cartList", cartList);
        return "redirect:/myCart";
    }


    @RequestMapping(value = "/removeItem/{id}", method = RequestMethod.GET)
    public String removeItem(Model model, HttpServletRequest request, @PathVariable int id) {
        List<CartEntity> cartList = (List<CartEntity>) request.getSession().getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
            request.getSession().setAttribute("cartList", cartList);
        }
        // Find id of item in list to remove
        CartEntity item = cartList.stream()
                .filter(p -> id == (p.getProduct().getId()))
                .findAny()
                .orElse(null);

        cartList.remove(item);

        request.getSession().setAttribute("cartList", cartList);
        model.addAttribute("cartList", cartList);

        return "redirect:/myCart";
    }

    private int exists(int id, List<CartEntity> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        // Because i = 0
        return -1;
    }
}
