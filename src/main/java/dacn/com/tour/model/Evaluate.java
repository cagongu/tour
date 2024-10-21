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
    @Column(name = "idEvaluate")
    Long idEvaluate;

    @Column(name = "numberStarHotel")
    Integer numberStarHotel;

    @Column(name = "numberStarFood")
    Integer numberStarFood;

    @Column(name = "numberStarVehicle")
    Integer numberStarVehicle;

    @Column(name = "numberStarTourGuide")
    Integer numberStarTourGuide;

    @Column(name = "numberStarSchedule")
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
