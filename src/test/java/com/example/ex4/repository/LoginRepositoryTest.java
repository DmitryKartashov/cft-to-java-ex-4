package com.example.ex4.repository;

import com.example.ex4.TestUtils;
import com.example.ex4.enums.Application;
import com.example.ex4.model.Login;
import com.example.ex4.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LoginRepositoryTest {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void saveTest() {
        Login login = TestUtils.createNewLogin();

        userRepository.save(login.getUser());
        loginRepository.save(login);

        boolean exists =  loginRepository.existsByUser(login.getUser());

        assertThat(exists).isEqualTo(true);
    }
}
