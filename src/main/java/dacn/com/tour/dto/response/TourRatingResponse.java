package dacn.com.tour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourRatingResponse {
    private Long idTour;
    private String image;
    private String titleTour;
    private Double avgRating;
    private Long ratingCount;
}