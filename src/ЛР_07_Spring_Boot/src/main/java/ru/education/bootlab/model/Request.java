package ru.education.bootlab.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /** Уникальный идентификатор сообщения, не более 32 символов. */
    @NotBlank @Size(max = 32)
    private String uid;
    /** Уникальный идентификатор операции, не более 32 символов. */
    @NotBlank @Size(max = 32)
    private String operationUid;
    /** Необязательное имя системы отправителя. */
    private Systems systemName;
    /** Обязательное время создания входящего сообщения. */
    @NotBlank
    private String systemTime;
    /** Необязательное наименование ресурса. */
    private String source;
    /** Идентификатор коммуникации в диапазоне от 1 до 100000. */
    @NotNull @Min(1) @Max(100000)
    private Integer communicationId;
    /** Необязательный идентификатор шаблона. */
    private Integer templateId;
    /** Необязательный код продукта. */
    private Integer productCode;
    /** Необязательный код SMS. */
    private Integer smsCode;
    /** Должность сотрудника; блок премии необязателен, но передается целиком. */
    private Positions position;
    /** Оклад сотрудника, положительная конечная величина. */
    private Double salary;
    /** Множитель премирования, неотрицательная конечная величина. */
    private Double bonus;
    /** Число отработанных дней, от 1 до длины расчетного года. */
    private Integer workDays;
    /** Расчетный год; по умолчанию текущий. */
    private Integer calculationYear;
    /** Номер квартала 1–4; применяется только к управленцам. */
    private Integer quarter;
}
