package com.Proxym.EventManagementSys.controller;
import com.Proxym.EventManagementSys.service.Impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;


@AllArgsConstructor
@RestController
@RequestMapping("/api/test")
public class testController {
    private final UserDetailsServiceImpl userDetailsService;
    @GetMapping("/currentUserName")
    public String getCurrentUserName(Principal principal){
       String s = principal.getName();
        return s;
    }
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

}
