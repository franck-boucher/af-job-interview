package com.fboucher.afjobinterview.service;

import com.fboucher.afjobinterview.dao.UserRepository;
import com.fboucher.afjobinterview.model.User;
import com.fboucher.afjobinterview.service.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get the user with an uuid param, throw an UserNotFoundException if not found.
     *
     * @param uuid
     * @return fetched User
     */
    public User getByUuid(String uuid) {
        return userRepository.findByUuid(uuid).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Register a new user and return it.
     *
     * @param user
     * @return newly registered User
     */
    public User register(User user) {
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

}
