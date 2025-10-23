package ru.vasilkov.Service2.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilkov.Service2.exception.UnsupportedCodeException;
import ru.vasilkov.Service2.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void checkUid(String uid) throws UnsupportedCodeException;
}
