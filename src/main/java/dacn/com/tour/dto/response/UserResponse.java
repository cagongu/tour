package dacn.com.tour.dto.response;


import java.sql.Timestamp;
import java.util.UUID;

public class UserResponse {
    Long idAccount;
    String name;
    String email;
    String phone;
    String address;
    String gender;
    Timestamp dob;
    String role;
    String username;
    String password;
    String avatar;
    String idFacebook;
    String idGoogle;
    String website;
    int verify;
    String verifyToken;
    String currentIp;
    String statusAction;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;
}
