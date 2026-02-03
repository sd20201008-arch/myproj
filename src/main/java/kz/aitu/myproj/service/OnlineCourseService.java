package kz.aitu.myproj.service;

import kz.aitu.myproj.entity.OnlineCourse;
import kz.aitu.myproj.repository.OnlineCourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OnlineCourseService {
    private final  OnlineCourseRepository repo;
    public OnlineCourseService(OnlineCourseRepository repo) {
        this.repo = repo;
    }

public List<OnlineCourse> getAll(){
        return repo.findAll();
}

public OnlineCourse getById(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Online course not found: " + id));
}

    public OnlineCourse create(OnlineCourse c) {
        if (c.getCourseId() == null) {
            throw new RuntimeException("courseId is required (no auto-generation in DB)");
        }
        if (repo.existsById(c.getCourseId())) {
            throw new RuntimeException("courseId already exists: " + c.getCourseId());
        }
        return repo.save(c);
    }


    public OnlineCourse update(Integer id, OnlineCourse newData) {
        OnlineCourse old = getById(id);
        old.setCourseName(newData.getCourseName());
        old.setCourseAvailable(newData.getCourseAvailable());
        return repo.save(old);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Online course not found: " + id);
        }
        repo.deleteById(id);
    }

}
