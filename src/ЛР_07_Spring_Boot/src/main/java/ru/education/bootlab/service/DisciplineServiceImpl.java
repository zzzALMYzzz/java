package ru.education.bootlab.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.education.bootlab.entity.Discipline;
import ru.education.bootlab.dao.DisciplineDao;
import ru.education.bootlab.exception.EntityNotFoundException;
@Service @RequiredArgsConstructor @Transactional
public class DisciplineServiceImpl implements DisciplineService {
 private final DisciplineDao dao;
 @Transactional(readOnly=true) public List<Discipline> findAll() {return dao.findAll();}
 @Transactional(readOnly=true) public Discipline findById(Long id) {return dao.findById(id).orElseThrow(()->new EntityNotFoundException("Discipline",id));}
 public Discipline create(Discipline value) {value.setId(null);return dao.save(value);}
 public Discipline update(Long id,Discipline value) {findById(id);value.setId(id);return dao.save(value);}
 public void delete(Long id) {dao.delete(findById(id));}
}
