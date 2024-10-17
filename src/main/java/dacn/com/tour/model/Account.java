package dacn.com.tour.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID idAccount;

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
    String CurrentIp;

    String statusAction;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateAdded;
    @UpdateTimestamp
    Timestamp dateEdited;
//    Timestamp dateDeleted;

}
