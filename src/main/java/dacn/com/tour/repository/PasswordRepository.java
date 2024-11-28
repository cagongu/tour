package dacn.com.tour.repository;

import dacn.com.tour.model.ForgotPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<ForgotPassword, String> {
}