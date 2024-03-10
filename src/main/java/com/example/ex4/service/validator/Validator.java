package com.example.ex4.service.validator;

public interface Validator<T> {
    boolean validate(T object);
}
