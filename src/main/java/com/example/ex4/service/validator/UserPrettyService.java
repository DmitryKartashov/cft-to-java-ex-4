package com.example.ex4.service.validator;

import com.example.ex4.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPrettyService implements PrettyService<User>{
    @Override
    public User makeUp(User element) {
        String[] fio = element.getFio().trim().split(" ");
        for (int i = 0; i < fio.length; i++) {
            fio[i] = fio[i].substring(0,1).toUpperCase() + fio[i].substring(1);
        }
        element.setFio(String.join(" ", fio));
        return element;
    }
}
