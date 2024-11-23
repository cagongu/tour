package dacn.com.tour.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dacn.com.tour.model.CustomerInfo;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {
    Long idOrder;

    int adult;
    int children;
    int baby;

    Boolean acceptPolice;

    String customerName;
    String address;
    String phone;
    String email;
    String notes;
    boolean evaluate;

    String total;

    Set<CustomerInfo> customerInfoList;

    PromotionResponse promotion;
    UserResponse account;
    TourResponse tour;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;
}
