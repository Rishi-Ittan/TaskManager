package com.kasa.task_manager.service;

import com.kasa.task_manager.model.user.LoginRequest;
import com.kasa.task_manager.model.user.SignupRequest;
import com.kasa.task_manager.model.user.UserDto;

public interface AuthService {
    LoginRequest login(LoginRequest request);
    UserDto signup(SignupRequest request);
}
