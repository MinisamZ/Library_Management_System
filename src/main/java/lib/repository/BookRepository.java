package lib.repository;

import lib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.id = ?1 ")
    Integer findNumberBooksById(Long id);
}
