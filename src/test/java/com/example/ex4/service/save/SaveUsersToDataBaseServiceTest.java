package com.example.ex4.service.save;

import com.example.ex4.TestUtils;
import com.example.ex4.model.User;
import com.example.ex4.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SaveUsersToDataBaseServiceTest {
    @Autowired
    private SaveUsersToDataBaseService saveUsersToDataBaseService;

    @Autowired
    UserRepository userRepository;

    @Test
    void save() {
        List<User> users = new ArrayList<>();
        users.add(TestUtils.createNewUser());

        saveUsersToDataBaseService.save(users);

        Assertions.assertTrue(userRepository.existsByUsername(users.get(0).getUsername()));
    }
}
