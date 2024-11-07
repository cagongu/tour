package dacn.com.tour.service;


import dacn.com.tour.dto.request.UserCreateRequest;
import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.UserResponse;
import dacn.com.tour.model.Favorite;

import java.util.List;


public interface UserService {
    List<UserResponse> listAll();
    UserResponse read(Long id);
    UserResponse readByEmail(String email);
    UserResponse create(UserCreateRequest request);
    UserResponse update(Long id, UserUpdateRequest request);
    void delete(Long id);

}
