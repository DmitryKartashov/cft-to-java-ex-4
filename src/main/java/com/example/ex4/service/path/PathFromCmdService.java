package com.example.ex4.service.path;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class PathFromCmdService implements PathService{

    @Override
    public String getPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String path = scanner.next();
        scanner.close();
        return path;
    }
}
