package mvc.service;

import mvc.entity.OrderDetailsEntity;
import mvc.entity.OrdersEntity;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired

    OrderDetailsRepository orderDetailsRepository;

    public List<OrdersEntity> findAll() {
        return (List<OrdersEntity>) ordersRepository.findAll();
    }

    public List<OrderDetailsEntity> findAllOrderDetailsByOrderId(int id) {
        return orderDetailsRepository.findAllOrderDetailsByOrderId(id);
    }

    public List<OrdersEntity> findByCustomerNameContaining(String searchInput) {
        return ordersRepository.findByCustomerNameContaining(searchInput);
    }
}
