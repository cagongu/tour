package dacn.com.tour.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import dacn.com.tour.model.Image;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigUpdateRequest {
    String infoType;
    String content;
    String image;
    String url;

    String statusAction;
    Set<Image> images;
}
