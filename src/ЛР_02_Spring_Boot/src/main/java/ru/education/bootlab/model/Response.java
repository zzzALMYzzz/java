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
    private String code;
    /** Код ошибки или пустая строка при успехе. */
    private String errorCode;
    /** Описание ошибки или пустая строка при успехе. */
    private String errorMessage;
}
