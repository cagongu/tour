package dacn.com.tour.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dacn.com.tour.model.Account;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {
    Long idOrder;

    String PIN;
    String status;
    double totalPrice;

    String address;
    String phone;
    String email;
    String notes;
    String customerName;
    int adult;
    int children;
    String travelType;
    private String buyer;

    String statusAction;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;

    Account account;

    TourResponse tour;
}
