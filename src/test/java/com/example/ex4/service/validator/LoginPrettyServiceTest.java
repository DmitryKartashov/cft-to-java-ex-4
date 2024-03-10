package com.example.ex4.service.validator;

import com.example.ex4.TestUtils;
import com.example.ex4.enums.Application;
import com.example.ex4.model.Login;
import com.example.ex4.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginPrettyServiceTest {
    @Autowired
    private LoginPrettyService loginPrettyService;

    @Test
    void makeUpOther() {
        Login login = TestUtils.createNewLogin();
        login.setApplication("ooooooowwww");
        var normApp = "other: " + login.getApplication();

        login = loginPrettyService.makeUp(login);

        Assertions.assertEquals(normApp, login.getApplication());
    }

    @Test
    void makeUp() {
        Login login = TestUtils.createNewLogin();
        login.setApplication(Application.MOBILE.name());
        var normApp = Application.MOBILE.name();

        login = loginPrettyService.makeUp(login);

        Assertions.assertEquals(normApp, login.getApplication());
    }
}
