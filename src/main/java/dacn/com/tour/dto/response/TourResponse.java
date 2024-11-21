package dacn.com.tour.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import dacn.com.tour.enums.StatusAction;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TourResponse {
    Long idTour;
    String titleTour;
    double price;
    Double childPrice;
    Double babyPrice;
    double sale;

    Timestamp departureDate;// ngay khoi hanh
    Timestamp returnDate; // ngay tro ve
    String description;
    String address;
    String duration;// for instance: 1 ngay mot dem

    String type;

    Long tagId;
    Long serviceId;

    int views;
    int votes;
    int purchaseCount;

    StatusAction status;
    String statusAction;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;

    @JsonIgnore
    Set<Booking> bookings;

    String image;

    @JsonIgnore
    Set<Favorite> favorites;
}
