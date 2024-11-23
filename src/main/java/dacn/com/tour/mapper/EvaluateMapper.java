package dacn.com.tour.mapper;

import dacn.com.tour.dto.response.EvaluateResponse;
import dacn.com.tour.model.Evaluate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EvaluateMapper {

    @Mapping(target = "accountId", source = "account.idAccount")
    @Mapping(target = "bookingId", source = "booking.idOrder")
    EvaluateResponse evaluateToResponse(Evaluate evaluate);
}
