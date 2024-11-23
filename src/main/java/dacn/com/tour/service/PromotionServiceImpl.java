package dacn.com.tour.service;

import dacn.com.tour.dto.request.PromotionCreationRequest;
import dacn.com.tour.dto.request.PromotionUpdateRequest;
import dacn.com.tour.dto.response.PromotionResponse;
import dacn.com.tour.enums.StatusAction;
import dacn.com.tour.exception.AppException;
import dacn.com.tour.exception.ErrorCode;
import dacn.com.tour.mapper.PromotionMapper;
import dacn.com.tour.model.Promotion;
import dacn.com.tour.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {
    private final PromotionMapper promotionMapper;
    private final PromotionRepository promotionRepository;

    @Override
    public List<PromotionResponse> getAllPromotion() {
        return promotionRepository.findAll().stream()
                .map(promotionMapper::promotionToPromotionResponse)
                .filter(promotionResponse -> promotionResponse.getStatusAction() != StatusAction.DELETE).toList();
    }

    @Override
    public PromotionResponse createNewPromotion(PromotionCreationRequest request) {
        Promotion promotion = promotionMapper.promotionRequestToPromotion(request);

        promotion.setCode(UUID.randomUUID().toString());

        promotionRepository.save(promotion);

        return promotionMapper.promotionToPromotionResponse(promotion);
    }

    @Override
    public PromotionResponse getById(Long id) {
        return promotionMapper.promotionToPromotionResponse(
                promotionRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PROMOTION_NOT_FOUND)));
    }

    @Override
    public PromotionResponse updateBy(Long id, PromotionUpdateRequest request) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PROMOTION_NOT_FOUND));

        promotionMapper.updatePromotion(promotion, request);

        promotionRepository.save(promotion);

        return promotionMapper.promotionToPromotionResponse(promotion);
    }

    @Override
    public PromotionResponse deleteById(Long id) {
        return null;
    }
}
