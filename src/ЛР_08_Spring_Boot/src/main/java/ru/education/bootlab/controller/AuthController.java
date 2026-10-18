package ru.education.bootlab.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.education.bootlab.model.UserDto;
import ru.education.bootlab.service.UserService;
@Controller @RequiredArgsConstructor
public class AuthController {
 private final UserService service;
 @GetMapping("/login") public String login() {return "login";}
 @GetMapping("/register") public String register(Model model) {model.addAttribute("user",new UserDto());return "register";}
 @PostMapping("/register/save") public String save(@Valid @ModelAttribute("user") UserDto user,BindingResult result) {
  if(!result.hasErrors()) {
   try {service.saveUser(user);return "redirect:/register?success";}
   catch(IllegalArgumentException e) {result.reject("registration",e.getMessage());}
   catch(org.springframework.dao.DataIntegrityViolationException e) {result.reject("registration","Пользователь с таким email уже зарегистрирован");}
  }
  user.setPassword(null);return "register";
 }
 @GetMapping("/users") public String users(Model model) {model.addAttribute("users",service.findAllUsers());return "users";}
}
