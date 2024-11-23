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
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTimeline;

    String title;
    String description;
    Timestamp date;

    String statusAction;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateAdded;

    @UpdateTimestamp
    Timestamp dateEdited;
    Timestamp dateDeleted;

    @ManyToOne
    Tour tour;
}
