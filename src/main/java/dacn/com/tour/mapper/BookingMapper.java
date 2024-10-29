package dacn.com.tour.mapper;

import dacn.com.tour.dto.request.BookingCreateRequest;
import dacn.com.tour.dto.request.BookingUpdateRequest;
import dacn.com.tour.dto.response.BookingResponse;
import dacn.com.tour.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookingMapper {
    @Mapping(target = "idOrder", ignore = true)
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    Booking bookingCreateRequestToBooking(BookingCreateRequest request);


    BookingResponse bookingToBookingResponse(Booking booking);

    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    @Mapping(target = "account", ignore = true)
    @Mapping(target = "tour", ignore = true)
    void updateBooking(@MappingTarget Booking booking, BookingUpdateRequest request);
}
