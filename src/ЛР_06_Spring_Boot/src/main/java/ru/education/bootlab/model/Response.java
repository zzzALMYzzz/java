package ru.education.bootlab.model;

import lombok.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Response {
    /** Идентификатор входящего сообщения. */
    private String uid;
    /** Идентификатор операции. */
    private String operationUid;
    /** Время формирования ответа в UTC. */
    private String systemTime;
    /** Результат обработки: success либо failed. */
    private Codes code;
    /** Код ошибки или пустая строка при успехе. */
    private ErrorCodes errorCode;
    /** Описание ошибки или пустая строка при успехе. */
    private ErrorMessages errorMessage;
    /** Подробности ошибки, включая имена некорректных полей. */
    private String details;
    /** Рассчитанная годовая премия, если передан блок расчета. */
    private Double annualBonus;
    /** Квартальная премия для управленца, если указан квартал. */
    private Double quarterlyBonus;
}
