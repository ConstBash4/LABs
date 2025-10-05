package ru.vasilkov.Lab2Application.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilkov.Lab2Application.exception.UnsupportedCodeException;
import ru.vasilkov.Lab2Application.exception.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
    @Override
    public void checkUid(String uid) throws UnsupportedCodeException {
        if (uid.equals("123")) {
            throw new UnsupportedCodeException("Неправильный UID");
        }
    }
}
