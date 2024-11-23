package dacn.com.tour.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEvaluate;

    Integer numberStar;

    String title;
    String content;

    @CreationTimestamp
    Timestamp dateAdded;

    @ManyToOne
    Account account;

    @ManyToOne
    Booking booking;
}
