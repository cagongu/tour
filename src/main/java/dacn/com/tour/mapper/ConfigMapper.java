package dacn.com.tour.mapper;

import dacn.com.tour.dto.request.ConfigCreateRequest;
import dacn.com.tour.dto.request.ConfigUpdateRequest;
import dacn.com.tour.dto.request.UserCreateRequest;
import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.ConfigResponse;
import dacn.com.tour.dto.response.UserResponse;
import dacn.com.tour.model.Account;
import dacn.com.tour.model.Config;
import org.mapstruct.*;

@Mapper
public interface ConfigMapper {
    @Mapping(target = "idConfig", ignore = true)
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    Config configCreationRequestToUser(ConfigCreateRequest request);

    ConfigResponse configToConfigResponse(Config config);

    @Mapping(target = "idConfig", ignore = true)
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // Bỏ qua các thunk tính null
    void updateConfig(@MappingTarget Config config, ConfigUpdateRequest request);
}
