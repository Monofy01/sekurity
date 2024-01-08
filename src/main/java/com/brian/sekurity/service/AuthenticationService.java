package com.brian.sekurity.service;

import com.brian.sekurity.dto.AuthenticationRequest;
import com.brian.sekurity.dto.AuthenticationResponse;
import com.brian.sekurity.entity.User;
import com.brian.sekurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    AuthenticationResponse login(AuthenticationRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authenticationManager.authenticate(authToken);

        User user = userRepository.findUserByUsername(authRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims(user))
        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(User user) {

    }
}
