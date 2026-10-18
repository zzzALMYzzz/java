package ru.education.bootlab.config;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;
import ru.education.bootlab.dao.UserRepository;
import ru.education.bootlab.service.UserServiceImpl;
@Service @RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
 private final UserRepository users;
 public UserDetails loadUserByUsername(String email) {
  ru.education.bootlab.entity.User user=users.findByEmail(UserServiceImpl.normalize(email))
   .orElseThrow(()->new UsernameNotFoundException("Неверные учетные данные"));
  return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword())
   .authorities(user.getRoles().stream().map(ru.education.bootlab.entity.Role::getName).toArray(String[]::new)).build();
 }
}
