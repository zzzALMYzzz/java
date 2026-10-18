package ru.education.bootlab.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import ru.education.bootlab.entity.Discipline;
import ru.education.bootlab.service.DisciplineService;
import ru.education.bootlab.model.ApiResult;
import java.util.List;
@RestController @RequestMapping("/api/disciplines") @RequiredArgsConstructor
public class DisciplineRestController {
 private final DisciplineService service;
 @GetMapping public ApiResult<List<Discipline>> list() {return ApiResult.ok("Список получен",service.findAll());}
 @GetMapping("/{id}") public ApiResult<Discipline> get(@PathVariable Long id) {return ApiResult.ok("Запись найдена",service.findById(id));}
 @PostMapping public ResponseEntity<ApiResult<Discipline>> create(@Valid @RequestBody Discipline value) {
  Discipline saved=service.create(value);
  return ResponseEntity.created(java.net.URI.create("/api/disciplines/"+saved.getId())).body(ApiResult.ok("Запись создана",saved));
 }
 @PutMapping("/{id}") public ApiResult<Discipline> update(@PathVariable Long id,@Valid @RequestBody Discipline value) {return ApiResult.ok("Запись изменена",service.update(id,value));}
 @PutMapping public ApiResult<Discipline> updateBody(@Valid @RequestBody Discipline value) {
  if(value.getId()==null)throw new IllegalArgumentException("id: обязателен при изменении");
  return update(value.getId(),value);
 }
 @DeleteMapping("/{id}") public ApiResult<Void> delete(@PathVariable Long id) {service.delete(id);return ApiResult.ok("Запись удалена",null);}
}
