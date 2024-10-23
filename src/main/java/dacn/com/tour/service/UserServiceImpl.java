package dacn.com.tour.service;

import dacn.com.tour.dto.request.UserCreateRequest;
import dacn.com.tour.dto.request.UserUpdateRequest;
import dacn.com.tour.dto.response.UserResponse;
import dacn.com.tour.enums.Role;
import dacn.com.tour.exception.AppException;
import dacn.com.tour.exception.ErrorCode;
import dacn.com.tour.mapper.UserMapper;
import dacn.com.tour.model.Account;

import dacn.com.tour.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final AccountRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> listAll() {
        log.info("Get all user is ran");
        List<Account> accounts = userRepository.findAll();
        List<UserResponse> response = accounts.stream().map(userMapper::userToUserResponse).toList();
        return response;
    }

    @Override
    public UserResponse read(Long id) {
        log.info("Get by id is ran");
        return userMapper.userToUserResponse(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserResponse readByEmail(String email) {
        log.info("Get by email is ran");
        return userMapper.userToUserResponse(userRepository.findUserByEmail(email));
    }

    @Override
    public UserResponse create(UserCreateRequest request) {
        log.info("Create new user is ran");
        try {
            userRepository.findUserByUsername(request.getUsername());
        } catch (AppException exception) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        Account account = userMapper.userCreationRequestToUser(request);
        account.setPassword(passwordEncoder.encode(request.getPassword()));

        account.setRole(Role.USER.name());

        return userMapper.userToUserResponse(userRepository.save(account));
    }

    @Override
    public UserResponse update(Long id, UserUpdateRequest request) {
        log.info("Update user is ran");
        Account account = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(account, request);

        if (StringUtils.hasText(request.getPassword())) {
            account.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        if (StringUtils.hasText(request.getRole()) && !request.getRole().equals(account.getRole())) {
            account.setRole(request.getRole());
        }

        return userMapper.userToUserResponse(userRepository.save(account));
    }

    @Override
    public void delete(Long id) {
        log.info("Delete user is ran");
        var user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userRepository.deleteById(user.getIdAccount());
    }
}
