package com.example.ex4.service.load;

import com.example.ex4.TestUtils;
import com.example.ex4.model.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LoginLoadServiceTest {
    @Autowired
    private LoginLoadService loginLoadService;

    @Test
    void readLoginsCreateLogin()  {
        List<Login> logins = loginLoadService.load(TestUtils.pathToTestFile);
        assertThat(logins.get(0).getUser().getFio()).isEqualTo("Kartashov Dmitry Dmitrievich");
    }

    @Test
    void readLoginsEmptyAccessDate()  {
        List<Login> logins = loginLoadService.load(TestUtils.pathToTestFile);
        assertThat(logins.size()).isEqualTo(TestUtils.normLinesCountInFile);
    }
}
