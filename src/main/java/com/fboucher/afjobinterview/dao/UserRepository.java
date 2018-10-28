package com.fboucher.afjobinterview.dao;

import com.fboucher.afjobinterview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUuid(String uuid);
}
