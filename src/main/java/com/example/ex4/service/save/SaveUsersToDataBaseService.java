package com.example.ex4.service.save;

import com.example.ex4.model.User;
import com.example.ex4.repository.UserRepository;
import com.example.ex4.service.validator.UserPrettyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveUsersToDataBaseService implements SaveService<User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPrettyService userPrettyService;

    @Override
    @Transactional
    public void save(List<User> elementsToSave) {
        var res = elementsToSave.stream().map(userPrettyService::makeUp).toList();
        userRepository.saveAll(res);
    }
}
