package com.imranmadbar.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String myApp() {
        return "This is from App home controller";
    }

    @GetMapping("/home")
    public String appHome() {
        return "This is from home controller";
    }


}
