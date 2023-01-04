package repository;

import entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
    @Query(value = "select n from CustomerEntity n where n.name like ?1%")
    List<CustomerEntity> findByStartName(String name);

    //@Query(value = "Select * from CustomerEntity n where n.phone = ?", nativeQuery = true)
    List<CustomerEntity> findByPhone(int phone);

    List<CustomerEntity> findByEmail(String email);

    List<CustomerEntity> findByPhoneOrEmail(int phone, String email);

    @Query(value = "select * from CustomerEntity n where n.sex = 'male' and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), birthdate)), '%Y') + 0  between 20 and 30", nativeQuery = true)
    List<CustomerEntity> listMen();


}
