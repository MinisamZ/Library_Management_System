package lib.repository;

import lib.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListBorrowedRepository extends JpaRepository<LogEntry, Long> {
    @Query("select l from LogEntry l where l.returned = ?1 ")
    List<LogEntry> findByReturned(@Param("returned") boolean b);
}
