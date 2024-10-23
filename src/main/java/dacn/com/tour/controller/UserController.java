package dacn.com.tour.controller;

import dacn.com.tour.dto.request.UserCreateRequest;
import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.dto.response.UserResponse;
import dacn.com.tour.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/identity")
public class UserController {
    private final UserService userService;
    private static final String USER_PATH = "/users";
    private static final String USER_PATH_ID = USER_PATH + "/{userId}";

    @PostMapping(USER_PATH)
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.create(request))
                .build();
    }

    @GetMapping(USER_PATH)
    ApiResponse<List<UserResponse>> getUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.listAll())
                .build();
    }

    @GetMapping(USER_PATH_ID)
    ApiResponse<UserResponse> getUser(@PathVariable("userId") Long id) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.read(id))
                .build();
    }


    @PutMapping(USER_PATH_ID)
    ApiResponse<UserResponse> updateUser(@PathVariable("userId") Long id, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.update(id, request))
                .build();
    }

    @DeleteMapping(USER_PATH_ID)
    ApiResponse<String> deleteUser(@PathVariable("userId") Long id) {
        userService.delete(id);
        return ApiResponse.<String>builder().result("User has been deleted").build();
    }
}

