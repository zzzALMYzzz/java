package ru.education.bootlab.exception;

public class UnsupportedCodeException extends RuntimeException {
    public UnsupportedCodeException() { super("Не поддерживаемая ошибка: uid=123"); }
}
