package com.example.bean_validation.repository;


import com.example.bean_validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Long> {
}
