package dacn.com.tour.service;

import dacn.com.tour.dto.request.TourCreationRequest;
import dacn.com.tour.dto.request.TourUpdateRequest;
import dacn.com.tour.dto.response.TourResponse;

import java.util.List;

public interface TourService {
    List<TourResponse> listAll();
    List<TourResponse> listAllByDescription(String name);
    TourResponse getById(Long id);
    TourResponse create(TourCreationRequest request);
    TourResponse update(Long id, TourUpdateRequest request);
    void delete(Long id);
}
