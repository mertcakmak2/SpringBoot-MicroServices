package com.microservices.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "user service fallback";
    }

    @GetMapping("departmentServiceFallBack")
    public String departmentServiceFallBackMethod(){
        return "department service fallback";
    }
}
