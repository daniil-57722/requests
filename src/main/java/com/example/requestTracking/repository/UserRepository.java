package com.example.requestTracking.repository;

import com.example.requestTracking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginAndPassword(String login, String password);
    User findByLogin(String login);

    List<User> findAllByLogin(String username);
}
