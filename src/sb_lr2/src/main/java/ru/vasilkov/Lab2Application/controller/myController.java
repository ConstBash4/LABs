package ru.vasilkov.Lab2Application.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilkov.Lab2Application.exception.UnsupportedCodeException;
import ru.vasilkov.Lab2Application.exception.ValidationFailedException;
import ru.vasilkov.Lab2Application.model.Request;
import ru.vasilkov.Lab2Application.model.Response;
import ru.vasilkov.Lab2Application.service.ValidationService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class myController {

    private  final ValidationService validationService;

    @Autowired
    public myController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    Response response = Response.builder()
            .uid(request.getUid())
            .operationUid(request.getOperationUid())
            .systemTime(simpleDateFormat.format(new Date()))
            .code("success")
            .errorCode("")
            .errorMessage("")
            .build();

    try {
        validationService.isValid(bindingResult);
        validationService.checkUid(request.getUid());
    } catch (UnsupportedCodeException e) {
        response.setCode("failed");
        response.setErrorCode("UnsupportedCodeException");
        response.setErrorMessage("Не поддерживаемая ошибка");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch (ValidationFailedException e) {
        response.setCode("failed");
        response.setErrorCode("ValidationException");
        response.setErrorMessage("Ошибка валидации");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
        response.setCode("failed");
        response.setErrorCode("UnknownException");
        response.setErrorMessage("Произошла непредвиденная ошибка");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
