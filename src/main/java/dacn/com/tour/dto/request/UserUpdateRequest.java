package dacn.com.tour.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String name;
    String email;
    String phone;
    String address;
    String gender;
    Timestamp dob;

    String role;
    String password;

    String avatar;

    String idFacebook;
    String idGoogle;

    String website;

    int verify;
    String verifyToken;
    String statusAction;
}
