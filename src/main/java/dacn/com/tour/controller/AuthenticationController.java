package dacn.com.tour.controller;

import com.nimbusds.jose.JOSEException;
import dacn.com.tour.dto.request.AuthenticationRequest;
import dacn.com.tour.dto.request.IntrospectRequest;
import dacn.com.tour.dto.request.LogoutRequest;
import dacn.com.tour.dto.request.RefreshRequest;
import dacn.com.tour.dto.response.ApiResponse;
import dacn.com.tour.dto.response.AuthenticationResponse;
import dacn.com.tour.dto.response.IntrospectResponse;
import dacn.com.tour.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/identity/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder().result(result).build();
    }

    @PostMapping("/refresh")
    ApiResponse<Void> refresh(@RequestBody RefreshRequest request) throws ParseException, JOSEException {
        authenticationService.refreshToken(request);
        return ApiResponse.<Void>builder().build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder().build();
    }
//    VerifyEmail
//    Reset password
}
