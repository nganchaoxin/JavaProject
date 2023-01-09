package repository;

import entity.AccountEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    @Modifying
    @Query(value = "update account set looked = true where access_time < now();", nativeQuery = true)
    void updateAccount();

    @Modifying
    @Query(value = "delete from account where balance = 0;", nativeQuery = true)
    void deleteAccount();
}
