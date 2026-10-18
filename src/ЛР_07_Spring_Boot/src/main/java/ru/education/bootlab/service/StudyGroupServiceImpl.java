package ru.education.bootlab.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.education.bootlab.entity.StudyGroup;
import ru.education.bootlab.dao.StudyGroupDao;
import ru.education.bootlab.exception.EntityNotFoundException;
@Service @RequiredArgsConstructor @Transactional
public class StudyGroupServiceImpl implements StudyGroupService {
 private final StudyGroupDao dao;
 @Transactional(readOnly=true) public List<StudyGroup> findAll() {return dao.findAll();}
 @Transactional(readOnly=true) public StudyGroup findById(Long id) {return dao.findById(id).orElseThrow(()->new EntityNotFoundException("StudyGroup",id));}
 public StudyGroup create(StudyGroup value) {value.setId(null);return dao.save(value);}
 public StudyGroup update(Long id,StudyGroup value) {findById(id);value.setId(id);return dao.save(value);}
 public void delete(Long id) {dao.delete(findById(id));}
}
