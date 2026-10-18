package ru.education.bootlab.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.education.bootlab.model.UserDto;
import ru.education.bootlab.entity.*;
import ru.education.bootlab.dao.*;
import java.util.*;
@Service @RequiredArgsConstructor @Transactional
public class UserServiceImpl implements UserService {
 private final UserRepository users;
 private final RoleRepository roles;
 private final PasswordEncoder encoder;
 public void saveUser(UserDto dto) {
  String email=normalize(dto.getEmail());
  if(users.existsByEmail(email))throw new IllegalArgumentException("Пользователь с таким email уже зарегистрирован");
  if(dto.getPassword().getBytes(java.nio.charset.StandardCharsets.UTF_8).length>72)
   throw new IllegalArgumentException("Пароль должен занимать не более 72 байт UTF-8");
  Role role=roles.findByName("ROLE_USER").orElseGet(()->{Role r=new Role();r.setName("ROLE_USER");return roles.save(r);});
  User user=new User();user.setFirstName(dto.getFirstName().trim());user.setLastName(dto.getLastName().trim());
  user.setEmail(email);user.setPassword(encoder.encode(dto.getPassword()));user.getRoles().add(role);
  users.saveAndFlush(user);
 }
 @Transactional(readOnly=true) public User findByEmail(String email) {return users.findByEmail(normalize(email)).orElse(null);}
 @Transactional(readOnly=true) public List<User> findAllUsers() {return users.findAll();}
 public static String normalize(String email) {return email.trim().toLowerCase(Locale.ROOT);}
}
