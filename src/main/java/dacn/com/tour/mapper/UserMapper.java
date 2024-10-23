package dacn.com.tour.mapper;

import dacn.com.tour.dto.request.UserCreateRequest;
import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.UserResponse;
import dacn.com.tour.model.Account;
import org.mapstruct.*;

@Mapper
public interface UserMapper {
    @Mapping(target = "idAccount", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    Account userCreationRequestToUser(UserCreateRequest request);

    UserResponse userToUserResponse(Account account);

    @Mapping(target = "idAccount", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "dateEdited", ignore = true)
    @Mapping(target = "dateDeleted", ignore = true)
    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // Bỏ qua các thunk tính null
    void updateUser(@MappingTarget Account account, UserUpdateRequest request);
}
