package com.example.ex4.service.save;

import com.example.ex4.model.Login;
import com.example.ex4.model.User;
import com.example.ex4.repository.LoginRepository;
import com.example.ex4.repository.UserRepository;
import com.example.ex4.service.validator.LoginPrettyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveLoginsToDataBaseService implements SaveService<Login>{

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private SaveUsersToDataBaseService saveUsersToDataBaseService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginPrettyService loginPrettyService;

    @Override
    @Transactional
    public void save(List<Login> elementsToSave) {
        var usersUnsave = elementsToSave.stream().map(Login::getUser).filter(
                user -> !userRepository.existsByUsername(user.getUsername())
        ).toList();

        saveUsersToDataBaseService.save(usersUnsave);

        var res = elementsToSave.stream().map(loginPrettyService::makeUp).toList();

        loginRepository.saveAll(res);
    }
}
