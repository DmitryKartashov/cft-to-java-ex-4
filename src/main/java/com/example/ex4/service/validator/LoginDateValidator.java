package com.example.ex4.service.validator;

import com.example.ex4.model.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class LoginDateValidator implements Validator<String>{
    @Override
    public boolean validate(String object) {
        if (object == null || object.isEmpty()) {
            return false;
        }

        try {
            Timestamp.valueOf(object);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }
}
