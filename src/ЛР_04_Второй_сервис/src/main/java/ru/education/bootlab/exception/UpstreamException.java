package ru.education.bootlab.exception;
public class UpstreamException extends RuntimeException {
 public UpstreamException(Throwable cause) { super("Второй сервис недоступен",cause); }
}
