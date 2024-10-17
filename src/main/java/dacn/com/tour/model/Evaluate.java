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
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    int numberStar;

    String title;
    String content;


    String statusAction;

    @CreationTimestamp
    Timestamp dateAdded;

    @UpdateTimestamp
    @Column(updatable = false)
    Timestamp dateEdited;
//    Timestamp dateDeleted;

    @ManyToOne
    Account account;

    @ManyToOne
    Tour tour;
}
