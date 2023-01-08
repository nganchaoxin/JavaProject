package repository;

import entity.OrdersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {
    @Query(value = "select * from orders where month(order_date) = month(curdate()) and year(order_date) = year(curdate());", nativeQuery = true)
    List<OrdersEntity> getOrderInCurrentMonth();
    @Query(value = "select * from orders inner join order_details on orders.id = order_details.orderId where order_quantity*order_unit_price>1000 ;", nativeQuery = true)
    List<OrdersEntity> getOrderFromTotal();

    @Query(value = "select * from orders inner join order_details on orders.id = order_details.orderId where order_details.order_product_name= 'Java Book' ;", nativeQuery = true)
    List<OrdersEntity> getOrderFromJavaBook();
}
