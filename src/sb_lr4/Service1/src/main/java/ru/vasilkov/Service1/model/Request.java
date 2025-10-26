package ru.vasilkov.Service1.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank
    @Size(max = 32)
    private String uid; // уникальный идентификатор сообщения

    @NotBlank
    @Size(max = 32)
    private String operationUid; // уникальный идентификатор операции
    @Setter
    private Systems systemName; // имя системы отправителя
    @NotBlank
    private String systemTime; // время создания сообщения
    private String source; // наименование ресурса
    private Positions position; // наименовании позиции
    private Double salary; // заработная плата
    private Double bonus; // коэффициент премии
    private Integer workDays; // кол-во рабочих дней
    @Min(value = 1)
    @Max(value = 100000)
    private int communicationId; // уникальный идентификатор коммуникации
    private int templateId; // уникальный идентификатор шаблона
    private int productCode; // код продукта
    private int smsCode; // смс код

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", smsCode='" + smsCode +
                '}';
    }
}
