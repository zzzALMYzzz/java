package ru.education.bootlab.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.education.bootlab.exception.*;
import ru.education.bootlab.model.Request;
import ru.education.bootlab.model.Response;
import ru.education.bootlab.service.*;

@lombok.extern.slf4j.Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {
    private final ValidationService validationService;
    private final FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                              BindingResult result) {
        log.info("Received request: {}",request);
        try {
            validationService.isValid(result);
            return ResponseEntity.ok(feedbackService.process(request));
        } catch (ValidationFailedException e) {
            log.error("Validation failed: {}",e.getMessage());
            return ResponseEntity.badRequest().body(feedbackService.response(
                request, "failed", "ValidationException", e.getMessage()));
        } catch (UnsupportedCodeException e) {
            log.error("Unsupported request: {}",e.getMessage());
            return ResponseEntity.badRequest().body(feedbackService.response(
                request, "failed", "UnsupportedCodeException", e.getMessage()));
        }
    }
}
