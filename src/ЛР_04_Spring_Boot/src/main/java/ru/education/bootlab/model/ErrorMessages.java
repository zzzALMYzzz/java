package ru.education.bootlab.model;
import com.fasterxml.jackson.annotation.JsonValue;
public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Неподдерживаемый код"),
    UNKNOWN("Произошла непредвиденная ошибка"),
    UPSTREAM("Второй сервис недоступен");
    private final String value;
    ErrorMessages(String value) { this.value=value; }
    @JsonValue public String getValue() { return value; }
}
