package ru.vasilkov.Service1.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilkov.Service1.exception.UnsupportedCodeException;
import ru.vasilkov.Service1.exception.ValidationFailedException;
import ru.vasilkov.Service1.model.*;
import ru.vasilkov.Service1.service.ModifyRequestService;
import ru.vasilkov.Service1.service.ModifyResponseService;
import ru.vasilkov.Service1.service.SendRequestService;
import ru.vasilkov.Service1.service.ValidationService;
import ru.vasilkov.Service1.util.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class myController {

    private final ValidationService validationService;
    private final ModifyResponseService timeResponseService;
    private final ModifyResponseService uidResponseService;
    private final ModifyRequestService systemRequestService;
    private final ModifyRequestService sourceRequestService;
    private final SendRequestService sendRequestService;

    @Autowired
    public myController(@Qualifier("requestValidationService") ValidationService validationService,
                        @Qualifier("modifySystemTimeResponseService") ModifyResponseService timeResponseService,
                        @Qualifier("modifyOperationUidResponseService") ModifyResponseService uidResponseService,
                        @Qualifier("modifySystemNameRequestService") ModifyRequestService systemRequestService,
                        @Qualifier("modifySourceRequestService") ModifyRequestService sourceRequestService,
                        @Qualifier("sendModifiedRequestService") SendRequestService sendRequestService) {
        this.validationService = validationService;
        this.timeResponseService = timeResponseService;
        this.uidResponseService = uidResponseService;
        this.systemRequestService = systemRequestService;
        this.sourceRequestService = sourceRequestService;
        this.sendRequestService = sendRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        log.info("request: {}", request);

        String timeNow = DateTimeUtil.getCustomFormat().format(new Date());

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(timeNow)
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

        timeResponseService.modify(response);
        uidResponseService.modify(response);

        systemRequestService.modify(request);
        sourceRequestService.modify(request);
        request.setSystemTime(timeNow);
        sendRequestService.send(request);

        log.info("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
