package dacn.com.tour.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID idTour;

    String titleTour;
    double price;
    double sale;

    Timestamp departureDate;// ngay khoi hanh
    String departureAddress; // dia diem khoi hanh
    String description;

    String address;
    String duration;// for instance: 1 ngay mot dem
    String type;

    UUID tagId;
    UUID ServiceId;

    int vote;
    int purchaseCount;

    String statusAction;

    @CreationTimestamp
    Timestamp dateAdded;

    @UpdateTimestamp
    @Column(updatable = false)
    Timestamp dateEdited;
//    Timestamp dateDeleted;

    @ManyToOne
    Account account;

}
