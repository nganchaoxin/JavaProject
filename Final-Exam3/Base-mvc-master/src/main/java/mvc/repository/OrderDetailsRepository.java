package mvc.repository;

import mvc.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {
    @Query(value = "Select * from orderdetails where order_id = ?", nativeQuery = true)
    List<OrderDetailsEntity> findAllOrderDetailsByOrderId(int id);
}
