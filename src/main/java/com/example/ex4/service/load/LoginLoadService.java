package com.example.ex4.service.load;


import com.example.ex4.annotations.LogTransformation;
import com.example.ex4.model.Login;
import com.example.ex4.model.User;
import com.example.ex4.service.save.SaveUsersToDataBaseService;
import com.example.ex4.service.validator.LoginDateValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@LogTransformation
public class LoginLoadService implements LoadService<Login> {

    @Autowired
    private SaveUsersToDataBaseService usersToDataBaseService;

    @Autowired
    private LoginDateValidator loginDateValidator;

    private final int entriesFullCount = 4;
    private final int usernameEntry = 0;
    private final int fioEntry = 1;
    private final int accessDateEntry = 2;
    private final int applicationEntry = 3;

    @Override
    @Transactional
    public List<Login> load(String path) {
        List<Login> logins = new ArrayList<>();

        Login login;
        User user;
        Timestamp timestamp;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                String[] entries = line.trim().split(",");

                if (!lineIsFull(entries)) {
                    log.info("line is not full - must be " + entriesFullCount + " entries, given - "
                            + entries.length + "; line: " + line);
                    line = reader.readLine();
                    continue;
                }

                if (!loginDateValidator.validate(entries[accessDateEntry])) {
                    log.info(path + "; " + "user" + " " + entries[usernameEntry]
                            + " without date or bad date format: " + entries[accessDateEntry]);
                    line = reader.readLine();
                    continue;
                }

                timestamp = Timestamp.valueOf(entries[accessDateEntry]);

                user = User.builder()
                        .username(entries[usernameEntry])
                        .fio(entries[fioEntry])
                        .build();

                login = Login.builder()
                        .accessDate(timestamp)
                        .application(entries[applicationEntry])
                        .user(user)
                        .build();
                log.info(user.toString());
                log.info(login.toString());

                logins.add(login);
                line = reader.readLine();
            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return logins;
    }

    private boolean lineIsFull(String[] entries) {
        return entries.length == entriesFullCount;
    }
}
