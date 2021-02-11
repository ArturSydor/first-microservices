package com.microservice.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    private static final String defaultMessage = "%s service is not available at the moment. Please try again later.";

    @GetMapping("/user-service-fallback")
    public String userServiceFallBackMethod() {
        return String.format(defaultMessage, "User");
    }


    @GetMapping("/department-service-fallback")
    public String departmentServiceFallBackMethod() {
        return String.format(defaultMessage, "Department");
    }
}
