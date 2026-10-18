package ru.education.bootlab.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import ru.education.bootlab.exception.EntityNotFoundException;
@ControllerAdvice(assignableTypes={StudentController.class,StudyGroupController.class})
public class WebExceptionHandler {
 @ExceptionHandler(EntityNotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND)
 public String missing() {return "not-found";}
}
