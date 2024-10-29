package dacn.com.tour.mapper;

import dacn.com.tour.dto.request.TourCreationRequest;
import dacn.com.tour.dto.request.TourUpdateRequest;
import dacn.com.tour.dto.response.TourResponse;
import dacn.com.tour.model.Tour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TourMapper {
    @Mapping(target = "idTour", ignore = true)
    @Mapping(target = "tagId", ignore = true)
    @Mapping(target = "serviceId", ignore = true)
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    Tour tourCreateRequestToTour(TourCreationRequest request);

    TourResponse tourToTourResponse(Tour tour);

    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    void updateTour(@MappingTarget Tour tour, TourUpdateRequest request);
}
