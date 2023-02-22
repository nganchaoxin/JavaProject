package mvc.repository;

import mvc.entity.OrdersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {
    //List<OrdersEntity> findByCustomerNameContaining(String searchInput);
    @Query(value = "SELECT DISTINCT o.order_id, o.customer_name, o.order_date, p.pro_name  FROM orders o left join " +
            "orderdetails o1\n" +
            "on o.order_id = o1.order_id left join products p on o1.pro_id = p.pro_id\n" +
            "where\n" +
            "o.customer_name like %?1%\n" +
            "or o.order_date like %?1%\n" +
            "or p.pro_name like %?1%", nativeQuery = true)
    List<OrdersEntity> findByCustomerNameContaining(String searchInput);
}
