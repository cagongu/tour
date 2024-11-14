package dacn.com.tour.dto.request;

import dacn.com.tour.model.Booking;
import dacn.com.tour.model.Favorite;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.*;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TourUpdateRequest {
    private Long idTour;

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

    Set<Booking> bookings;
//    Set<Image> images;
    Set<Favorite> favorites;
}
