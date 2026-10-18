package ru.education.bootlab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import ru.education.bootlab.model.Response;
import ru.education.bootlab.service.FeedbackService;

@RestControllerAdvice(assignableTypes = MyController.class)
@RequiredArgsConstructor
public class FeedbackExceptionHandler {
    private final FeedbackService feedbackService;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response> malformedJson(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(feedbackService.response(
            null, "failed", "ValidationException", "Ошибка валидации: некорректное тело JSON"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> unexpected(Exception e) {
        return ResponseEntity.internalServerError().body(feedbackService.response(
            null, "failed", "UnknownException", "Произошла непредвиденная ошибка"));
    }
}
