package ru.vasilkov.Service1.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

        log.info("request: {}", request);
        Response response = buildInitialResponse(request);
        log.info("init response: {}", response);

        try {
            validateRequest(request, bindingResult);
            modifyResponse(response);
            modifyRequest(request);
            sendRequest(request);
        } catch (UnsupportedCodeException e) {
            return handleException(response, e, ErrorCodes.UNSUPPORTED_EXCEPTION, ErrorMessages.UNSUPPORTED, HttpStatus.BAD_REQUEST);
        } catch (ValidationFailedException e) {
            return handleException(response, e, ErrorCodes.VALIDATION_EXCEPTION, ErrorMessages.VALIDATION, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return handleException(response, e, ErrorCodes.UNKNOWN_EXCEPTION, ErrorMessages.UNKNOWN, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void validateRequest(Request request, BindingResult bindingResult) throws ValidationFailedException {
        validationService.isValid(bindingResult);
        validationService.checkUid(request.getUid());
    }

    private ResponseEntity<Response> handleException(Response response, Exception e, ErrorCodes errorCode, ErrorMessages errorMessage, HttpStatusCode httpCode) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMessage);

        log.info("{} response: {}", errorCode, response);
        log.error("{}: {}", errorCode, e.toString());

        return new ResponseEntity<>(response, httpCode);
    }

    private Response buildInitialResponse(Request request) {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    }

    private void modifyResponse(Response response) {
        timeResponseService.modify(response);
        uidResponseService.modify(response);
    }

    private void modifyRequest(Request request) {
        systemRequestService.modify(request);
        sourceRequestService.modify(request);
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
    }

    private void sendRequest(Request request) {
        sendRequestService.send(request);
    }
}
