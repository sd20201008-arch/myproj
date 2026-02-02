package kz.aitu.myproj.repository;

import kz.aitu.myproj.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository
        extends JpaRepository<University, Integer> {
}