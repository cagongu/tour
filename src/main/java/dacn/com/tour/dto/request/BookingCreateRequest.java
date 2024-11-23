package dacn.com.tour.dto.request;

import dacn.com.tour.model.Account;
import dacn.com.tour.model.CustomerInfo;
import dacn.com.tour.model.Promotion;
import dacn.com.tour.model.Tour;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingCreateRequest {
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

    Promotion promotion;
    Set<CustomerInfo> customerInfoList;
}
