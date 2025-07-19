package com.kasa.task_manager.service.impl;

import com.kasa.task_manager.exception.UserException;
import com.kasa.task_manager.model.entity.User;
import com.kasa.task_manager.model.user.SignupRequest;
import com.kasa.task_manager.repositories.UserRepository;
import com.kasa.task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createNewUser(SignupRequest request) throws UserException {
        var existingUser = userRepository.findByUsername(request.getUsername());
        if(existingUser.isPresent()) {
            log.error("User {} already exists!", request.getUsername());
            throw new UserException(String.format("User %s already exists", request.getUsername()));
        }
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        return saveUser(User.from(request));
    }

    private User saveUser(User user) {
        return userRepository.save(user);
    }
}
