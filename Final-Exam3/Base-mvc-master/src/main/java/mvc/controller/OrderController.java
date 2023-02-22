package mvc.controller;

import mvc.entity.OrderDetailsEntity;
import mvc.entity.OrdersEntity;
import mvc.repository.OrdersRepository;
import mvc.service.OrderService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {


    @Autowired
    OrderService orderService;

    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String showProduct(Model model) {
        List<OrdersEntity> ordersList = orderService.findAll();
        model.addAttribute("ordersList", ordersList);

        return "product/orders";
    }

    @RequestMapping(value = "/showOrderDetailsList/{id}", method = RequestMethod.GET)
    public String showOrderDetailsList(Model model, @PathVariable int id) {
        // find orderId in orderDetail to show item order list
        Optional<OrdersEntity> ordersEntity = ordersRepository.findById(id);
        if(ordersEntity.isPresent()){
            model.addAttribute("orderDetailsList", ordersEntity.get().getOrderDetails());
        }

        //model.addAttribute("orderDetailsList", orderService.findAllOrderDetailsByOrderId(id));

        return "product/orderDetailsList";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("searchInput") String searchInput,
                         Model model) {
        List<OrdersEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = (List<OrdersEntity>) orderService.findAll();

        } else {
            resultList = orderService.findByCustomerNameContaining(searchInput);
        }

        model.addAttribute("ordersList", resultList);

        return "product/orders";
    }
}
