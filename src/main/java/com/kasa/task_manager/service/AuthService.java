package com.kasa.task_manager.service;

import com.kasa.task_manager.model.user.LoginRequest;
import com.kasa.task_manager.model.user.LoginResponse;
import com.kasa.task_manager.model.user.SignupRequest;
import com.kasa.task_manager.model.user.UserDto;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    UserDto signup(SignupRequest request);
}
