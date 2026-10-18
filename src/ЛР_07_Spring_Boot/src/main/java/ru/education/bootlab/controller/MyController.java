package ru.education.bootlab.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import ru.education.bootlab.model.*;
import ru.education.bootlab.service.*;
import java.time.*;
@RestController @RequiredArgsConstructor @Slf4j
public class MyController {
 private final ValidationService validationService;
 private final FeedbackService feedbackService;
 private final ForwardingService forwardingService;
 @PostMapping("/feedback")
 public Response feedback(@Valid @RequestBody Request request,BindingResult result,
   @RequestHeader(value="X-Request-Received-At",required=false) String firstReceived) {
  Instant received=Instant.now();
  if(firstReceived!=null) {
   try {log.info("Service 1 -> Service 2: {} ms",Duration.between(Instant.parse(firstReceived),received).toMillis());}
   catch(java.time.format.DateTimeParseException e) {log.error("Invalid receive timestamp: {}",firstReceived);}
  }
  log.info("Received request: {}",request);
  validationService.isValid(result);
  Response response=feedbackService.process(request);
  forwardingService.forward(request,received);
  return response;
 }
}
