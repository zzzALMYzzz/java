package ru.education.bootlab.model;
import com.fasterxml.jackson.annotation.JsonValue;
public enum ErrorCodes {
    EMPTY(""),
    VALIDATION_EXCEPTION("ValidationException"),
    UNSUPPORTED_EXCEPTION("UnsupportedCodeException"),
    UNKNOWN_EXCEPTION("UnknownException"),
    UPSTREAM_EXCEPTION("UpstreamException");
    private final String value;
    ErrorCodes(String value) { this.value=value; }
    @JsonValue public String getValue() { return value; }
}
