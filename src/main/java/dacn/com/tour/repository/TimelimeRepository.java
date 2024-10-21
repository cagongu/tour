package dacn.com.tour.repository;

import dacn.com.tour.model.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimelimeRepository extends JpaRepository<Timeline, Long> {
}
