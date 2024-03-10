package com.example.ex4.service.validator;

import com.example.ex4.enums.Application;
import com.example.ex4.model.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginPrettyService implements PrettyService<Login> {
    @Override
    public Login makeUp(Login element) {
        var application = element.getApplication();
        if (!checkEnum(application)) {
            element.setApplication("other: " + application);
        }
        return element;
    }

    public boolean checkEnum(String matchValue) {
        for (Application application : Application.values()) {
            if (application.name().equals(matchValue)) {
                return true;
            }
        }
        return false;
    }
}
