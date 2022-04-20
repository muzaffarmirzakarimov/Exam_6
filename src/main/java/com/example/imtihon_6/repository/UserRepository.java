package com.example.imtihon_6.repository;


import com.example.imtihon_6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByName(String name);

    Optional findByUsername(String username);
}
