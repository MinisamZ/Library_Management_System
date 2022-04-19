package lib.repository;

import lib.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListBorrowedRepository extends JpaRepository<LogEntry, Long> {
}
