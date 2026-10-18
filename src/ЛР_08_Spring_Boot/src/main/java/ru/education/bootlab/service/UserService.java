package ru.education.bootlab.service;
import ru.education.bootlab.model.UserDto;
import ru.education.bootlab.entity.User;
import java.util.List;
public interface UserService {
 void saveUser(UserDto user);
 User findByEmail(String email);
 List<User> findAllUsers();
}
