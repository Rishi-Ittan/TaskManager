package com.kasa.task_manager.service;

import com.kasa.task_manager.exception.UserException;
import com.kasa.task_manager.model.entity.User;
import com.kasa.task_manager.model.user.SignupRequest;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    User createNewUser(SignupRequest request) throws UserException;
}
