package dacn.com.tour.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
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

    Integer numberStarHotel;

    Integer numberStarFood;

    Integer numberStarVehicle;

    Integer numberStarTourGuide;

    Integer numberStarSchedule;

    String title;
    String contentEvaluate;

    BigDecimal rateAverage;
    String rateTitle;
    String typeEvaluate;

    String statusAction;

    @CreationTimestamp
    Timestamp dateAdded;

    @UpdateTimestamp
    @Column(updatable = false)
    Timestamp dateEdited;
    Timestamp dateDeleted;

    @ManyToOne
    Account account;

    @ManyToOne
    Tour tour;
}
