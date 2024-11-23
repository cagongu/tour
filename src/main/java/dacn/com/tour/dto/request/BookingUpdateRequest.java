package dacn.com.tour.dto.request;

import dacn.com.tour.model.CustomerInfo;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @Builder.Default
    boolean evaluate = false;

    String total;

    PromotionUpdateRequest promotion;
    Set<CustomerInfo> customerInfoList;
}
