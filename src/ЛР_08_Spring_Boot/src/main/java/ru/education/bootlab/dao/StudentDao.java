package ru.education.bootlab.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.bootlab.entity.Student;
public interface StudentDao extends JpaRepository<Student,Long> {}
