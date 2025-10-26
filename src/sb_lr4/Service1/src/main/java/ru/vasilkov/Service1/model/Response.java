package ru.vasilkov.Service1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String uid; // уникальный идентификатор сообщения
    private String operationUid; // уникальный идентификатор операции
    private String systemTime; // имя системы отправителя
    private Codes code; // код операции
    private Double annualBonus; // годовая премия
    private ErrorCodes errorCode; // код ошибки
    private ErrorMessages errorMessage; // сообщение об ошибке

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", code='" + code + '\'' +
                ", annualBonus='" + annualBonus + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage +
                '}';
    }
}
