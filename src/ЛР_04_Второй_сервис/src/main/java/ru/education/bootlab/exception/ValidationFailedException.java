package ru.education.bootlab.exception;

public class ValidationFailedException extends RuntimeException {
    public ValidationFailedException(String message) { super(message); }
}
