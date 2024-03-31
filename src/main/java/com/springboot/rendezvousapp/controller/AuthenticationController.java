package com.springboot.rendezvousapp.controller;

import com.springboot.rendezvousapp.dto.JwtAuthenticationResponse;
import com.springboot.rendezvousapp.dto.RefreshTokenRequest;
import com.springboot.rendezvousapp.dto.SignUpRequest;
import com.springboot.rendezvousapp.dto.SigninRequest;
import com.springboot.rendezvousapp.entities.User;
import com.springboot.rendezvousapp.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        System.out.println("Received signup request: " + signUpRequest);
        User user = authenticationService.signup(signUpRequest);
        System.out.println("User created: " + user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
