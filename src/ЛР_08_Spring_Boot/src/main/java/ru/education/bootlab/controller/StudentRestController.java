package ru.education.bootlab.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import ru.education.bootlab.entity.Student;
import ru.education.bootlab.service.StudentService;
import ru.education.bootlab.model.ApiResult;
import java.util.List;
@RestController @RequestMapping("/api/students") @RequiredArgsConstructor
public class StudentRestController {
 private final StudentService service;
 @GetMapping public ApiResult<List<Student>> list() {return ApiResult.ok("Список получен",service.findAll());}
 @GetMapping("/{id}") public ApiResult<Student> get(@PathVariable Long id) {return ApiResult.ok("Запись найдена",service.findById(id));}
 @PostMapping public ResponseEntity<ApiResult<Student>> create(@Valid @RequestBody Student value) {
  Student saved=service.create(value);
  return ResponseEntity.created(java.net.URI.create("/api/students/"+saved.getId())).body(ApiResult.ok("Запись создана",saved));
 }
 @PutMapping("/{id}") public ApiResult<Student> update(@PathVariable Long id,@Valid @RequestBody Student value) {return ApiResult.ok("Запись изменена",service.update(id,value));}
 @PutMapping public ApiResult<Student> updateBody(@Valid @RequestBody Student value) {
  if(value.getId()==null)throw new IllegalArgumentException("id: обязателен при изменении");
  return update(value.getId(),value);
 }
 @DeleteMapping("/{id}") public ApiResult<Void> delete(@PathVariable Long id) {service.delete(id);return ApiResult.ok("Запись удалена",null);}
}
