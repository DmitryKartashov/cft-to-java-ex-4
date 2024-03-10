package com.example.ex4.repository;

import com.example.ex4.TestUtils;
import com.example.ex4.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void saveAndExistsByUsername() {
        User user = TestUtils.createNewUser();

        userRepository.save(user);

        boolean exists =  userRepository.existsByUsername(user.getUsername());

        assertThat(exists).isEqualTo(true);
    }

}
