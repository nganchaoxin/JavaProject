package mvc.repository;

import mvc.entity.ProductsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductsEntity, Integer> {
}
