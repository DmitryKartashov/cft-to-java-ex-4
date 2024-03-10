package com.example.ex4;

import com.example.ex4.enums.Application;
import com.example.ex4.model.Login;
import com.example.ex4.model.User;

import java.sql.Timestamp;

public final class TestUtils {

    public static final String pathToTestFile = "./src/test/resources/TestLoginsFile";
    public static final int normLinesCountInFile = 3;
    public static User createNewUser() {
        User user = User.builder()
                .username("test user " + System.currentTimeMillis())
                .fio("Тестов Тест Тестович")
                .build();

        return user;
    }

    public static Login createNewLogin() {
        Login login = Login.builder()
                .application(Application.WEB.name())
                .user(createNewUser())
                .accessDate(new Timestamp(System.currentTimeMillis()))
                .build();

        return login;
    }
}
