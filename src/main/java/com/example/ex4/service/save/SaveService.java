package com.example.ex4.service.save;

import java.util.List;

public interface SaveService<T> {
    void save(List<T> elementsToSave);
}
