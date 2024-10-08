package com.example.SecurityWeb.repository;

import com.example.SecurityWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
