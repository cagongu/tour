package dacn.com.tour.repository;

import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
