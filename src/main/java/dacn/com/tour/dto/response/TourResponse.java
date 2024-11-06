package dacn.com.tour.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dacn.com.tour.model.Account;
import dacn.com.tour.model.Booking;
import dacn.com.tour.model.Image;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TourResponse {
    Long idTour;
    String titleTour;
    double price;
    double sale;

    Timestamp departureDate;// ngay khoi hanh
    String description;
    String address;
    String duration;// for instance: 1 ngay mot dem

    String type;

    Long tagId;
    Long serviceId;

    int views;
    int votes;
    int purchaseCount;

    String statusAction;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;

    @JsonIgnore
    Set<Booking> bookings;

    Set<Image> images;
}
