package com.Proxym.EventManagementSys.service.Impl;
import com.Proxym.EventManagementSys.dto.LoginRequest;
import com.Proxym.EventManagementSys.dto.RegistrationResponse;
import com.Proxym.EventManagementSys.dto.JwtResponse;
import com.Proxym.EventManagementSys.exception.errorCodes;
import com.Proxym.EventManagementSys.exception.eventManagSysException;
import com.Proxym.EventManagementSys.exception.invalidEntityException;
import com.Proxym.EventManagementSys.dto.registerRequest;
import com.Proxym.EventManagementSys.model.*;
import com.Proxym.EventManagementSys.repository.RoleRepository;
import com.Proxym.EventManagementSys.repository.UserRepository;
import com.Proxym.EventManagementSys.repository.VerificationTokenRepository;
import com.Proxym.EventManagementSys.security.JwtUtils;
import com.Proxym.EventManagementSys.service.AuthService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.Proxym.EventManagementSys.utils.Constants.ACTIVATION_EMAIL;
import static java.time.Instant.now;
@Slf4j
@Data
@Service
public class AuthServiceImp implements AuthService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public RegistrationResponse signup(registerRequest registerRequest){


        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setCreated(now());
        user.setEnabled(false);
        Set<String> strRoles = registerRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "user":
                        Role userRole = roleRepository.findByName(ERole.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                        break;
                    case "booker":
                        Role bookerRole = roleRepository.findByName(ERole.BOOKER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(bookerRole);
                        break;
                    case "event_owner":
                        Role event_ownerRole = roleRepository.findByName(ERole.EVENT_OWNER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(event_ownerRole);
                        break;

                }
            });
        }
        user.setRoles(roles);
        if ( userRepository.existsByUserName(user.getUserName()))  {
            log.error("user  is there : username {}");
            throw new invalidEntityException("user with this  is already in the DB ", errorCodes.USER_NOT_VALID);
        }
        else if (userRepository.existsByEmail(user.getEmail()))
        {
            log.error("user  is there : Email {}");
            throw new invalidEntityException("user with this email is already in the DB ", errorCodes.USER_NOT_VALID);
        }
        else {
            userRepository.save(user);
            String token = generateVerificationToken(user);
            String message = mailContentBuilder.build("Thank you for signing up to Spring Reddit, please click on the below url to activate your account : "
                    + ACTIVATION_EMAIL + "/" + token);
            mailService.sendMail(new NotificationEmail("Please Activate your Account",
                    user.getEmail(), "Thank you for signing up to Spring Reddit, " +
                    "please click on the below url to activate your account : " + "http://localhost:8080/api/auth/accountVerification/" + token));
        }

        return RegistrationResponse
                .builder()
                .email(user.getEmail())
                .creationDate(OffsetDateTime.now())
                .build();
    }

    @Override
    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationTokenOptional = verificationTokenRepository.findByToken(token);
        verificationTokenOptional.orElseThrow(() -> new eventManagSysException("Invalid Token"));
        fetchUserAndEnable(verificationTokenOptional.get());
    }

    @Override
    public void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUserName();
        User user = userRepository.findByUserName(username)
                .orElseThrow(() ->
                        new eventManagSysException("User Not Found with id - " + username));
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public JwtResponse authenticateUser(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        log.debug("Authenticate User");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return JwtResponse
                .builder()
                .email(userDetails.getEmail())
                .username(userDetails.getUsername())
                .roles(roles)
                .token(jwtUtils.generateJwtToken(authentication))
                .build();
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
