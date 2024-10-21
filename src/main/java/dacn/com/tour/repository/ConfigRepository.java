package dacn.com.tour.repository;

import dacn.com.tour.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
    List<Config> findConfigByInfoTypeIsLikeIgnoreCase(String infoType);
}
