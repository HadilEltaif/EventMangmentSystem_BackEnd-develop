package com.Proxym.EventManagementSys.service;

import com.Proxym.EventManagementSys.dto.JwtResponse;
import com.Proxym.EventManagementSys.dto.LoginRequest;
import com.Proxym.EventManagementSys.dto.RegistrationResponse;
import com.Proxym.EventManagementSys.dto.registerRequest;
import com.Proxym.EventManagementSys.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public interface AuthService {

    RegistrationResponse signup(registerRequest registerRequest);

    void verifyAccount(String token);

    void fetchUserAndEnable(VerificationToken verificationToken);

    String generateVerificationToken(User user);

    String encodePassword(String password);

    JwtResponse authenticateUser(LoginRequest loginRequest);


}
