package ru.education.bootlab.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.bootlab.entity.Discipline;
public interface DisciplineDao extends JpaRepository<Discipline,Long> {}
