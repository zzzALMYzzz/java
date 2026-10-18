package ru.education.bootlab.service;
import java.util.List;
import ru.education.bootlab.entity.Student;
public interface StudentService {
 List<Student> findAll();
 Student findById(Long id);
 Student create(Student value);
 Student update(Long id,Student value);
 void delete(Long id);
}
