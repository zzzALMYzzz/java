package ru.education.bootlab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import ru.education.bootlab.model.Response;
import ru.education.bootlab.service.FeedbackService;

@lombok.extern.slf4j.Slf4j
@RestControllerAdvice(assignableTypes = MyController.class)
@RequiredArgsConstructor
public class FeedbackExceptionHandler {
    private final FeedbackService feedbackService;

    @ExceptionHandler(ru.education.bootlab.exception.ValidationFailedException.class)
    public ResponseEntity<Response> invalid(RuntimeException e) {
        log.error("Validation failed: {}",e.getMessage());
        return ResponseEntity.badRequest().body(feedbackService.response(null,"failed","ValidationException",e.getMessage()));
    }
    @ExceptionHandler(ru.education.bootlab.exception.UnsupportedCodeException.class)
    public ResponseEntity<Response> unsupported(RuntimeException e) {
        return ResponseEntity.badRequest().body(feedbackService.response(null,"failed","UnsupportedCodeException",e.getMessage()));
    }
    @ExceptionHandler(ru.education.bootlab.exception.UpstreamException.class)
    public ResponseEntity<Response> upstream(RuntimeException e) {
        return ResponseEntity.status(502).body(feedbackService.response(null,"failed","UpstreamException",e.getMessage()));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response> malformedJson(HttpMessageNotReadableException e) {
        log.error("Malformed JSON: {}", e.getMessage());
        return ResponseEntity.badRequest().body(feedbackService.response(
            null, "failed", "ValidationException", "Ошибка валидации: некорректное тело JSON"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> unexpected(Exception e) {
        log.error("Unexpected error", e);
        return ResponseEntity.internalServerError().body(feedbackService.response(
            null, "failed", "UnknownException", "Произошла непредвиденная ошибка"));
    }
}
