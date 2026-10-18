package ru.education.bootlab.service;
import java.util.List;
import ru.education.bootlab.entity.StudyGroup;
public interface StudyGroupService {
 List<StudyGroup> findAll();
 StudyGroup findById(Long id);
 StudyGroup create(StudyGroup value);
 StudyGroup update(Long id,StudyGroup value);
 void delete(Long id);
}
