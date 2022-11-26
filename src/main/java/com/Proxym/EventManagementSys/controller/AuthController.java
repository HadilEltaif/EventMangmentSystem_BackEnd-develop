package com.Proxym.EventManagementSys.controller;


import com.Proxym.EventManagementSys.controller.api.AuthApi;
import com.Proxym.EventManagementSys.dto.JwtResponse;
import com.Proxym.EventManagementSys.dto.LoginRequest;
import com.Proxym.EventManagementSys.dto.RegistrationResponse;
import com.Proxym.EventManagementSys.dto.registerRequest;
import com.Proxym.EventManagementSys.exception.eventManagSysException;
import com.Proxym.EventManagementSys.model.User;
import com.Proxym.EventManagementSys.repository.UserRepository;
import com.Proxym.EventManagementSys.repository.VerificationTokenRepository;
import com.Proxym.EventManagementSys.security.JwtUtils;
import com.Proxym.EventManagementSys.service.AuthService;
import com.Proxym.EventManagementSys.service.Impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@Slf4j
public class AuthController implements AuthApi {

    private final AuthService authService;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<RegistrationResponse> signup(registerRequest registerRequest) {
        return ResponseEntity.ok(authService.signup(registerRequest));
    }

    @Override
    public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authenticateUser(loginRequest));
    }

    @Override
    public ResponseEntity<String> verifyAccount(String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successully", OK);
    }


    @Override
    public User getCurrentUserDetails(@NotNull Principal principal) {
        User userLocal = new User();
        String username = principal.getName();
        User currentUser = userRepository.findByUserName(username).orElseThrow(() -> new eventManagSysException("User Not Found with id - " + username));
        userLocal.setUserName(currentUser.getUserName());
        userLocal.setEmail(currentUser.getEmail());
        userLocal.setEnabled(currentUser.getEnabled());
        userLocal.setCreated(currentUser.getCreated());
        userLocal.setRoles(currentUser.getRoles());
        return userLocal;

    }


}