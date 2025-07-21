package com.kasa.task_manager.controller;

import com.kasa.task_manager.model.user.LoginRequest;
import com.kasa.task_manager.model.user.SignupRequest;
import com.kasa.task_manager.model.user.UserDto;
import com.kasa.task_manager.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginRequest> login(@Valid @RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(authService.login(request));
        } catch (Exception e) {
            log.error("Error logging in!", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@Valid @RequestBody SignupRequest request) {
        try {
            return ResponseEntity.ok().body(authService.signup(request));
        } catch (Exception e) {
            log.error("Could not sign up!", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
