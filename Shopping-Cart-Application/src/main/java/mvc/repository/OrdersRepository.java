package mvc.repository;

import mvc.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {
}
