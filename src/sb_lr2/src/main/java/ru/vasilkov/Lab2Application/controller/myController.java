package ru.vasilkov.Lab2Application.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilkov.Lab2Application.exception.UnsupportedCodeException;
import ru.vasilkov.Lab2Application.exception.ValidationFailedException;
import ru.vasilkov.Lab2Application.model.*;
import ru.vasilkov.Lab2Application.service.ValidationService;
import ru.vasilkov.Lab2Application.util.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class myController {

    private final ValidationService validationService;

    @Autowired
    public myController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("init response: {}", response);

        try {
            validationService.isValid(bindingResult);
            validationService.checkUid(request.getUid());
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.info("{} response: {}", ErrorCodes.UNSUPPORTED_EXCEPTION, response);
            log.error("{}: {}", ErrorCodes.UNSUPPORTED_EXCEPTION, e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.info("{} response: {}", ErrorCodes.VALIDATION_EXCEPTION, response);
            log.error("{}: {}", ErrorCodes.VALIDATION_EXCEPTION, e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("{} response: {}", ErrorCodes.UNKNOWN_EXCEPTION, response);
            log.error("{}: {}", ErrorCodes.UNKNOWN_EXCEPTION, e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
