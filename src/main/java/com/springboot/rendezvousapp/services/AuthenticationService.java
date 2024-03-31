package com.springboot.rendezvousapp.services;

import com.springboot.rendezvousapp.dto.JwtAuthenticationResponse;
import com.springboot.rendezvousapp.dto.RefreshTokenRequest;
import com.springboot.rendezvousapp.dto.SignUpRequest;
import com.springboot.rendezvousapp.dto.SigninRequest;
import com.springboot.rendezvousapp.entities.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
