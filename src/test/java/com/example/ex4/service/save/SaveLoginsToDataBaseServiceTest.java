package com.example.ex4.service.save;

import com.example.ex4.TestUtils;
import com.example.ex4.model.Login;
import com.example.ex4.repository.LoginRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SaveLoginsToDataBaseServiceTest {
    @Autowired
    private SaveLoginsToDataBaseService saveLoginsToDataBaseService;

    @Autowired
    private LoginRepository loginRepository;

    @Test
    void save() {
        List<Login> logins = new ArrayList<>();
        logins.add(TestUtils.createNewLogin());

        saveLoginsToDataBaseService.save(logins);

        Assertions.assertTrue(loginRepository.existsByUser(logins.get(0).getUser()));
    }
}
