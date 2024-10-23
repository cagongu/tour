package dacn.com.tour.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;
import dacn.com.tour.dto.request.AuthenticationRequest;
import dacn.com.tour.dto.request.IntrospectRequest;
import dacn.com.tour.dto.request.LogoutRequest;
import dacn.com.tour.dto.request.RefreshRequest;
import dacn.com.tour.dto.response.AuthenticationResponse;
import dacn.com.tour.dto.response.IntrospectResponse;
import dacn.com.tour.model.Account;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect(IntrospectRequest request) throws ParseException, JOSEException;

    String generateToken(Account user);

    void logout(LogoutRequest request) throws ParseException, JOSEException;

    AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException;

    SignedJWT verifyToken(String token, Boolean isRefresh) throws JOSEException, ParseException;
}
