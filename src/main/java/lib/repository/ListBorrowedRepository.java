package lib.repository;

import lib.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListBorrowedRepository extends JpaRepository<LogEntry, Long> {
    @Query("select l from LogEntry l where l.returned = ?1 ")
    List<LogEntry> findByReturned(@Param("returned") boolean b);

    @Query("select l from LogEntry l where l.idUser = ?1 ")
    List<LogEntry> findBEntryByStudentId(@Param("id_user") Long id);

    @Query("select l from LogEntry l where l.idUser = ?1 and l.returned =?2")
    List<LogEntry> findBEntryByStudentIdAndReturned(@Param("id_user") Long id, @Param("returned") boolean b);

    @Query("select l from LogEntry l where l.idUser = ?1 and l.idBook =?2")
    LogEntry findLogEntryByIdTableAndUser(@Param("id_user") Long id1, @Param("id_book") Long id2);
}
