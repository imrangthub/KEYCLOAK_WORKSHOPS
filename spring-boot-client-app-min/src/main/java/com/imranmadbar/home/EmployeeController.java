package com.imranmadbar.home;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @GetMapping("/home")
    public String myApp() {
        return "This is from EMPLOYEE home controller";
    }

    @GetMapping("/home2")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String appHome() {
        return "This is from EMPLOYEE home2 controller";
    }


}

