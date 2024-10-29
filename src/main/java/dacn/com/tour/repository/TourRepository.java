package dacn.com.tour.repository;

import dacn.com.tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findAllByDescriptionIsLikeIgnoreCase(String name);

}
