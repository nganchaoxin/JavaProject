package mvc.repository;

import mvc.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {
    @Query(value = "Select * from orderdetail where order_id = ?", nativeQuery = true)
    OrderDetailsEntity findByOrderId(int id);
}
