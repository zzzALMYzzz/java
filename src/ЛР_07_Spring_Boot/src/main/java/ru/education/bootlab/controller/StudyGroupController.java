package ru.education.bootlab.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.education.bootlab.entity.StudyGroup;
import ru.education.bootlab.service.StudyGroupService;
@Controller @RequiredArgsConstructor
public class StudyGroupController {
 private final StudyGroupService service;
 @GetMapping("/groups") public String list(Model model) {model.addAttribute("groups",service.findAll());return "list-groups";}
 @GetMapping("/addGroupForm") public String add(Model model) {model.addAttribute("studyGroup",new StudyGroup());return "add-group-form";}
 @GetMapping("/showGroupUpdateForm") public String edit(@RequestParam Long groupId,Model model) {model.addAttribute("studyGroup",service.findById(groupId));return "add-group-form";}
 @PostMapping("/saveGroup") public String save(@Valid @ModelAttribute("studyGroup") StudyGroup value,BindingResult result) {
  if(result.hasErrors())return "add-group-form";
  if(value.getId()==null)service.create(value);else service.update(value.getId(),value);
  return "redirect:/groups";
 }
 @PostMapping("/deleteGroup") public String delete(@RequestParam Long groupId) {service.delete(groupId);return "redirect:/groups";}
}
