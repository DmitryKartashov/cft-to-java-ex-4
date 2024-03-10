package com.example.ex4;


import com.example.ex4.annotations.LogTransformation;
import com.example.ex4.model.User;
import org.springframework.stereotype.Component;

@LogTransformation
@Component
public class TestClass {
    public boolean testMethod(User user) {
        return true;
    }
}
