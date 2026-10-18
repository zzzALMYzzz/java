package ru.education.bootlab.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.education.bootlab.entity.Student;
import ru.education.bootlab.service.StudentService;
@Controller @RequiredArgsConstructor
public class StudentController {
 private final StudentService service;
 @GetMapping("/list") public String list(Model model) {model.addAttribute("students",service.findAll());return "list-students";}
 @GetMapping("/addStudentForm") public String add(Model model) {model.addAttribute("student",new Student());return "add-student-form";}
 @GetMapping("/showUpdateForm") public String edit(@RequestParam Long studentId,Model model) {model.addAttribute("student",service.findById(studentId));return "add-student-form";}
 @PostMapping("/saveStudent") public String save(@Valid @ModelAttribute("student") Student value,BindingResult result) {
  if(result.hasErrors())return "add-student-form";
  if(value.getId()==null)service.create(value);else service.update(value.getId(),value);
  return "redirect:/list";
 }
 @PostMapping("/deleteStudent") public String delete(@RequestParam Long studentId) {service.delete(studentId);return "redirect:/list";}
}
