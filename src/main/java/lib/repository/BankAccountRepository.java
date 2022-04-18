package lib.repository;

import lib.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<User, Long> {


}
