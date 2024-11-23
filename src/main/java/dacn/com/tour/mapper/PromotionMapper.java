package dacn.com.tour.mapper;

import dacn.com.tour.dto.request.PromotionCreationRequest;
import dacn.com.tour.dto.request.PromotionUpdateRequest;
import dacn.com.tour.dto.response.PromotionResponse;
import dacn.com.tour.model.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {BookingMapper.class})
public interface PromotionMapper {
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", ignore = true)
    Promotion promotionRequestToPromotion(PromotionCreationRequest request);

    PromotionResponse promotionToPromotionResponse(Promotion promotion);

    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", ignore = true)
    void updatePromotion(@MappingTarget Promotion promotion, PromotionUpdateRequest request);
}
