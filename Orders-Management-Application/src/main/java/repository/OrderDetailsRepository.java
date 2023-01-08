package repository;

import entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {

    List<OrderDetailsEntity> findOrderById(int id);
}
