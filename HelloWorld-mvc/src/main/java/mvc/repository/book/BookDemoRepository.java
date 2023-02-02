package mvc.repository.book;

import mvc.entity.BookEntity;
import mvc.entity.BookEntityDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDemoRepository extends CrudRepository<BookEntityDemo, Integer> {
}
