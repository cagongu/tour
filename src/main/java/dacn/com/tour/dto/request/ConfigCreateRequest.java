package dacn.com.tour.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigCreateRequest {
    Long idConfig;
    String infoType;
    String content;
    String image;
    String url;

    String statusAction;
}