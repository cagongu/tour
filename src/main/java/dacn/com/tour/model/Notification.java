package dacn.com.tour.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
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
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID idNotification;

    String type;
    String status;
    String title;
    String content;

    Timestamp dateTime;// Thời gian bắt đầu ap dung

    String statusAction;

    @CreationTimestamp
    Timestamp dateAdded;

    @UpdateTimestamp
    @Column(updatable = false)
    Timestamp dateEdited;
//    Timestamp dateDeleted;

    @ManyToMany
    Set<Account> account;
}
