package mvc.repository.book;

import mvc.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByNameContainingOrAuthorContaining(String searchInput, String searchInput1);

    List<BookEntity> findAll();


//    @Query(value = "select n from CustomerEntity n where n.name like ?1%")
//    List<BookEntity> findByNameContainingOrAuthorContaining(String searchInput, String searchInput1);

}
