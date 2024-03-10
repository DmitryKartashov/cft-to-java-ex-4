package com.example.ex4.service.validator;

import com.example.ex4.TestUtils;
import com.example.ex4.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserPrettyServiceTest {
    @Autowired
    private UserPrettyService userPrettyService;

    @Test
    void makeUp() {
        User user = TestUtils.createNewUser();
        user.setFio("t");

        user = userPrettyService.makeUp(user);

        Assertions.assertTrue(Character.isUpperCase(user.getFio().charAt(0)));
    }
}
