package dacn.com.tour.service;

import dacn.com.tour.dto.request.PromotionCreationRequest;
import dacn.com.tour.dto.request.PromotionUpdateRequest;
import dacn.com.tour.dto.response.PromotionResponse;

import java.util.List;

public interface PromotionService {
    List<PromotionResponse> getAllPromotion();

    PromotionResponse createNewPromotion(PromotionCreationRequest request);

    PromotionResponse getById(Long id);

    PromotionResponse updateBy(Long id, PromotionUpdateRequest request);

    PromotionResponse deleteById(Long id);
}
