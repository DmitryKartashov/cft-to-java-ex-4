package com.example.ex4.service.load;

import java.io.FileNotFoundException;
import java.util.List;

public interface LoadService<T> {
    List<T> load(String path) throws FileNotFoundException;
}

