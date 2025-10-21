package ru.vasilkov.Lab2Application.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasilkov.Lab2Application.exception.UnsupportedCodeException;
import ru.vasilkov.Lab2Application.exception.ValidationFailedException;
import ru.vasilkov.Lab2Application.model.ErrorCodes;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().toString();
            log.error("bindingResult.isValid: {}", errorMessage);
            throw new ValidationFailedException(errorMessage);
        }
    }
    @Override
    public void checkUid(String uid) throws UnsupportedCodeException {
        if (uid.equals("123")) {
            String errorMessage = "Неправильный UID";
            log.error("checkUid: {}", errorMessage);
            throw new UnsupportedCodeException("Неправильный UID");
        }
    }
}
