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
    private final ForwardingService forwardingService;

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                              BindingResult result,
        @RequestHeader(value="X-Request-Received-At", required=false) String firstReceived) {
        java.time.Instant received=java.time.Instant.now();
        if (firstReceived!=null) {
            try { log.info("Service 1 -> Service 2: {} ms",java.time.Duration.between(java.time.Instant.parse(firstReceived),received).toMillis()); }
            catch(java.time.format.DateTimeParseException e) { log.error("Invalid receive timestamp: {}",firstReceived); }
        }
        log.info("Received request: {}",request);
        try {
            validationService.isValid(result);
            Response response=feedbackService.process(request);
            forwardingService.forward(request,received);
            return ResponseEntity.ok(response);
        } catch (UpstreamException e) {
            return ResponseEntity.status(502).body(feedbackService.response(request,"failed","UpstreamException",e.getMessage()));
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
