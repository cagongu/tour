package dacn.com.tour.dto.request;

import dacn.com.tour.model.Booking;
import dacn.com.tour.model.Image;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TourCreationRequest {
    String titleTour;
    double price;
    double sale;

    Timestamp departureDate;// ngay khoi hanh
    String description;
    String address;
    String duration;// for instance: 1 ngay mot dem

    String type;

    int views;
    int votes;
    int purchaseCount;

    String statusAction;

    Set<Image> images;
}
