package dacn.com.tour.dto.request;

import dacn.com.tour.model.Account;
import dacn.com.tour.model.Tour;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingUpdateRequest {
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

}
