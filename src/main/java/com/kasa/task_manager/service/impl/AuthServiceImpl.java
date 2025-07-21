package com.kasa.task_manager.service.impl;

import com.kasa.task_manager.exception.UserException;
import com.kasa.task_manager.model.user.LoginRequest;
import com.kasa.task_manager.model.user.SignupRequest;
import com.kasa.task_manager.model.user.UserDto;
import com.kasa.task_manager.security.JwtHelper;
import com.kasa.task_manager.service.AuthService;
import com.kasa.task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    @Override
    public LoginRequest login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String token = JwtHelper.generateToken(request.getUsername());
            return LoginRequest.builder()
                    .token(token)
                    .username(request.getUsername())
                    .build();
        } catch (BadCredentialsException e) {
            return LoginRequest.builder()
                    .username(request.getUsername())
                    .message("Invalid credentials")
                    .build();
        }
    }

    @Override
    public UserDto signup(SignupRequest request) {
        var responseBuilder = UserDto.builder().username(request.getUsername());
        try {
            userService.createNewUser(request);
            responseBuilder.message(String.format("User %s created successfully!", request.getUsername()));
        } catch (UserException e) {
            responseBuilder.message(e.getMessage());
        }
        return responseBuilder.build();
    }
}
