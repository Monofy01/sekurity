package com.brian.sekurity.controller;


import com.brian.sekurity.dto.AuthenticationRequest;
import com.brian.sekurity.dto.AuthenticationResponse;
import com.brian.sekurity.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Valid AuthenticationRequest authRequest) {

        AuthenticationResponse jwtDto = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }

    @GetMapping("/public-access")
    public String publicAccessMethod() {
        return "PUBLIC ENDPOINT";
    }

}
