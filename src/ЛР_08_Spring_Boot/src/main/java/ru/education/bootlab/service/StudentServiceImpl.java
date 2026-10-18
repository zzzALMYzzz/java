package ru.education.bootlab.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.education.bootlab.entity.Student;
import ru.education.bootlab.dao.StudentDao;
import ru.education.bootlab.exception.EntityNotFoundException;
@Service @RequiredArgsConstructor @Transactional
public class StudentServiceImpl implements StudentService {
 private final StudentDao dao;
 @Transactional(readOnly=true) public List<Student> findAll() {return dao.findAll();}
 @Transactional(readOnly=true) public Student findById(Long id) {return dao.findById(id).orElseThrow(()->new EntityNotFoundException("Student",id));}
 public Student create(Student value) {value.setId(null);return dao.save(value);}
 public Student update(Long id,Student value) {findById(id);value.setId(id);return dao.save(value);}
 public void delete(Long id) {dao.delete(findById(id));}
}
