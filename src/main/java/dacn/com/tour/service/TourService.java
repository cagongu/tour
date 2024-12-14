package dacn.com.tour.service;

import dacn.com.tour.dto.request.TourCreationRequest;
import dacn.com.tour.dto.request.TourUpdateRequest;
import dacn.com.tour.dto.response.TourRatingResponse;
import dacn.com.tour.dto.response.TourResponse;
import dacn.com.tour.dto.response.UserResponse;
import dacn.com.tour.model.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourService {
    List<TourResponse> listAll(String description, String type, String place);

    TourResponse getById(Long id);
    TourResponse create(TourCreationRequest request);
    TourResponse update(Long id, TourUpdateRequest request);
    TourResponse addFavorite(Long userId, Long tourId);
    TourResponse removeFavorite(Long userId, Long tourId);
    TourResponse delete(Long id);
    Page<TourRatingResponse> getToursSortedByRating(Pageable pageable);


    TourRatingResponse getTourRatingResponseById(Long id);
}
