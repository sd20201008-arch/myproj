package kz.aitu.myproj.repository;

import kz.aitu.myproj.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByCourse(String course);
}
