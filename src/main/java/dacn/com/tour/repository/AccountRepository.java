package dacn.com.tour.repository;

import dacn.com.tour.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findUserByEmail(String email);
    Boolean findUserByUsername(String username);
}
