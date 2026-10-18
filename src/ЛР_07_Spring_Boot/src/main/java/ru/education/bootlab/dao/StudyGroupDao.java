package ru.education.bootlab.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.bootlab.entity.StudyGroup;
public interface StudyGroupDao extends JpaRepository<StudyGroup,Long> {}
