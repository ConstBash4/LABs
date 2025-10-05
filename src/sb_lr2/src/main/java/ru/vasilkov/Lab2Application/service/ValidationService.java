package ru.vasilkov.Lab2Application.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilkov.Lab2Application.exception.UnsupportedCodeException;
import ru.vasilkov.Lab2Application.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void checkUid(String uid) throws UnsupportedCodeException;
}
