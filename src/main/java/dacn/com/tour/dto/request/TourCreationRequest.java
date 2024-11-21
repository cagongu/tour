package dacn.com.tour.dto.request;

import dacn.com.tour.enums.StatusAction;
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
public class TourCreationRequest {
    String titleTour;
    double price;
    Double childPrice;
    Double babyPrice;
    double sale;

    Timestamp departureDate;// ngay khoi hanh
    Timestamp returnDate;
    String description;
    String address;
    String duration;// for instance: 1 ngay mot dem

    String type;

    int views;
    int votes;
    int purchaseCount;

    StatusAction status;
    String statusAction;

    String image;
}
