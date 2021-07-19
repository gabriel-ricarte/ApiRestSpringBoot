package br.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.registration.RegistrationRequest;
import br.com.spring.registration.RegistrationService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/registration")
@AllArgsConstructor
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public String register (@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
