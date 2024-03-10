package com.example.ex4.repository;


import com.example.ex4.model.Login;
import com.example.ex4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    boolean existsByUser(User user);
}
