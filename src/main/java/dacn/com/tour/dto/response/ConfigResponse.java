package dacn.com.tour.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigResponse {
    String infoType;
    String content;
    String image;
    String url;
    String statusAction;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;
}
