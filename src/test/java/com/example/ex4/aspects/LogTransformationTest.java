package com.example.ex4.aspects;

import com.example.ex4.TestClass;
import com.example.ex4.TestUtils;
import com.example.ex4.annotations.LogTransformation;
import com.example.ex4.model.Login;
import com.example.ex4.model.User;
import com.example.ex4.service.load.LoginLoadService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class LogTransformationTest {
    @Autowired
    private LoginLoadService loginLoadService;

    @Autowired
    private TestClass testClass;

    @Test
    void putLogTest() {
        User user = TestUtils.createNewUser();

        var res = testClass.testMethod(user);

        try (BufferedReader reader = new BufferedReader(new FileReader(LogTransformationAspect.defaultLogFileName)))
        {
            var lineCount = reader.lines().count();
            Assertions.assertEquals(1, lineCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void deleteBefore() {
        File file = new File(LogTransformationAspect.defaultLogFileName);
        file.delete();
    }

    @AfterEach
    void deleteAfter() {
        File file = new File(LogTransformationAspect.defaultLogFileName);
        file.delete();
    }
}
