package dacn.com.tour.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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

//    @JsonIgnore
//    Set<Image> images;

    @JsonIgnore
    Set<Favorite> favorites;
}