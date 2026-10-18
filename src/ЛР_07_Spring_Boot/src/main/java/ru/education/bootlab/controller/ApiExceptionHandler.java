package ru.education.bootlab.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import ru.education.bootlab.exception.EntityNotFoundException;
import ru.education.bootlab.model.ApiResult;
@RestControllerAdvice(assignableTypes={StudentRestController.class,DisciplineRestController.class})
public class ApiExceptionHandler {
 private ResponseEntity<ApiResult<Void>> failure(int code,String message) {return ResponseEntity.status(code).body(new ApiResult<>(false,message,null));}
 @ExceptionHandler(EntityNotFoundException.class) public ResponseEntity<ApiResult<Void>> missing(EntityNotFoundException e) {return failure(404,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<ApiResult<Void>> invalid(MethodArgumentNotValidException e) {
  String errors=e.getBindingResult().getFieldErrors().stream().map(f->f.getField()+": "+f.getDefaultMessage()).sorted().collect(java.util.stream.Collectors.joining("; "));
  return failure(400,errors);
 }
 @ExceptionHandler({IllegalArgumentException.class,HttpMessageNotReadableException.class,MethodArgumentTypeMismatchException.class})
 public ResponseEntity<ApiResult<Void>> invalidInput(Exception e) {return failure(400,"Некорректные параметры запроса");}
 @ExceptionHandler(DataIntegrityViolationException.class) public ResponseEntity<ApiResult<Void>> conflict(Exception e) {return failure(409,"Нарушена целостность данных");}
}
