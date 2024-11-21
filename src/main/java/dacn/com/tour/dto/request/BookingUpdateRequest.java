package dacn.com.tour.dto.request;

import dacn.com.tour.model.Account;
import dacn.com.tour.model.CustomerInfo;
import dacn.com.tour.model.Tour;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingUpdateRequest {
    int adult;
    int children;
    int baby;

    Boolean acceptPolice;

    String customerName;
    String address;
    String phone;
    String email;
    String notes;

    String total;

    Set<CustomerInfo> customerInfoList;

}
