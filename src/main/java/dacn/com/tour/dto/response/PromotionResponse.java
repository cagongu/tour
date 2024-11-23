package dacn.com.tour.dto.response;

import dacn.com.tour.enums.StatusAction;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromotionResponse {
    Long id;
    String code;

     Double discountPercentage;
     Double maxDiscountAmount;
    int qualityOnHand;


    String description;

    boolean hidden;
    boolean active;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;

    StatusAction statusAction;

    Timestamp startDate;
    Timestamp endingDate;
}
