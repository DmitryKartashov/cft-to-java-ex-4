package com.example.ex4.service.validator;

import com.example.ex4.TestUtils;
import com.example.ex4.model.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginDateValidatorTest {
    @Autowired
    private LoginDateValidator loginDateValidator;

    @Test
    void validateTrue() {
        Assertions.assertTrue(loginDateValidator.validate("2023-02-24 22:22:16"));
    }

    @Test
    void validateFalse() {
        Assertions.assertFalse(loginDateValidator.validate(""));
    }
}
