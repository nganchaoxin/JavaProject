package mvc.controller;

import mvc.entity.CartEntity;
import mvc.entity.OrderDetailsEntity;
import mvc.entity.OrdersEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrdersRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CartController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    // Cart session
    @RequestMapping(value = "/myCart", method = RequestMethod.GET)
    public String showCartList(Model model, HttpSession session) {
        List<CartEntity> cartList = (List<CartEntity>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<>();
            model.addAttribute("cartList", cartList);
        }

        return "shoppingcart/cart";
    }

    // Add item to cart session
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

    // Check Out Page
    @RequestMapping(value = "/checkOut", method = RequestMethod.GET)
    public String showCheckOutPage(Model model, HttpServletRequest request, HttpSession session) {
        OrdersEntity orders = new OrdersEntity();
        orders.setOrderDate(LocalDate.now());

        // save cart into orderDetail
        List<CartEntity> cartList = (List<CartEntity>) session.getAttribute("cartList");
        List<OrderDetailsEntity> orderDetailsList = new ArrayList<>();

        for (int i = 0; i < cartList.size(); i++) {
            OrderDetailsEntity orderDetails = new OrderDetailsEntity();
            orderDetails.setProduct(cartList.get(i).getProduct());
            orderDetails.setQuantity(cartList.get(i).getQuantity());
            orderDetails.setProductName(cartList.get(i).getProduct().getName());
            orderDetailsList.add(orderDetails);

        }

        request.getSession().setAttribute("orderDetailsList", orderDetailsList);

        model.addAttribute("orders", orders);
        return "shoppingcart/checkOut";
    }

    // Init result of check out page
    @RequestMapping(value = "/resultOrders", method = RequestMethod.POST)
    public String processOrders(Model model, @ModelAttribute OrdersEntity orders, HttpServletRequest request, HttpSession session) {
        List<OrderDetailsEntity> orderDetailsList = (List<OrderDetailsEntity>) session.getAttribute("orderDetailsList");

        // save orders and set orders into orderDetailList(in session)
        ordersRepository.save(orders);
        for (int i = 0; i < orderDetailsList.size(); i++) {
            orderDetailsList.get(i).setOrders(orders);
        }
        // save all orderDetailList into table
        request.getSession().setAttribute("orderDetailsList", orderDetailsRepository.saveAll(orderDetailsList));

        return "redirect:/showOrdersList";
    }

    // Show orders list
    @RequestMapping(value = "/showOrdersList", method = RequestMethod.GET)
    public String showOrdersList(Model model) {
        List<OrdersEntity> ordersList = (List<OrdersEntity>) ordersRepository.findAll();

        model.addAttribute("ordersList", ordersList);
        return "shoppingcart/ordersList";
    }

    // Show order detail list
    @RequestMapping(value = "/showOrderDetailsList/{id}", method = RequestMethod.GET)
    public String showOrderDetailsList(Model model, @PathVariable int id) {
        // find orderId in orderDetail to show item order list
        model.addAttribute("orderDetailsList", orderDetailsRepository.findAllOrderDetailsByOrderId(id));

        return "shoppingcart/orderDetailsList";
    }

    // Remove item out of cart
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
