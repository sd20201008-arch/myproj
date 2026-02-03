package kz.aitu.myproj.repository;

import kz.aitu.myproj.entity.OnlineCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineCourseRepository extends JpaRepository<OnlineCourse, Integer> {
}
