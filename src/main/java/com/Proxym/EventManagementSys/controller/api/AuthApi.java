package com.Proxym.EventManagementSys.controller.api;

import com.Proxym.EventManagementSys.dto.JwtResponse;
import com.Proxym.EventManagementSys.dto.LoginRequest;
import com.Proxym.EventManagementSys.dto.registerRequest;
import com.Proxym.EventManagementSys.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;

import static com.Proxym.EventManagementSys.utils.Constants.APP_ROOT_V1;

public interface AuthApi {


    @PostMapping(value = APP_ROOT_V1 +"/signup",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@Valid @RequestBody registerRequest registerRequest);

    @PostMapping(value = APP_ROOT_V1 +"/signin",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);

    @GetMapping(value = APP_ROOT_V1 +"/accountVerification/{token}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> verifyAccount(@PathVariable String token);


    @GetMapping(value = APP_ROOT_V1 +"/current-user",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getCurrentUserDetails(Principal principal);


}
