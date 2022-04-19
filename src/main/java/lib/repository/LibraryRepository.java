package lib.repository;

import lib.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<User, Long> {


}
