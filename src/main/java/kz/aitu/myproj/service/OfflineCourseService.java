package kz.aitu.myproj.service;

import kz.aitu.myproj.entity.OfflineCourse;
import kz.aitu.myproj.repository.OfflineCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfflineCourseService {

    private final OfflineCourseRepository repo;

    public OfflineCourseService(OfflineCourseRepository repo) {
        this.repo = repo;
    }

    public List<OfflineCourse> getAll() {
        return repo.findAll();
    }

    public OfflineCourse getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Offline course not found: " + id));
    }

    public OfflineCourse create(OfflineCourse c) {
        if (c.getCourseId() == null) {
            throw new RuntimeException("courseId is required (no auto-generation in DB)");
        }
        if (repo.existsById(c.getCourseId())) {
            throw new RuntimeException("courseId already exists: " + c.getCourseId());
        }
        return repo.save(c);
    }

    public OfflineCourse update(Integer id, OfflineCourse newData) {
        OfflineCourse old = getById(id);
        old.setCourseName(newData.getCourseName());
        old.setCourseAvailable(newData.getCourseAvailable());
        return repo.save(old);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Offline course not found: " + id);
        }
        repo.deleteById(id);
    }
}

