package ru.education.bootlab.service;
import java.util.List;
import ru.education.bootlab.entity.Discipline;
public interface DisciplineService {
 List<Discipline> findAll();
 Discipline findById(Long id);
 Discipline create(Discipline value);
 Discipline update(Long id,Discipline value);
 void delete(Long id);
}
