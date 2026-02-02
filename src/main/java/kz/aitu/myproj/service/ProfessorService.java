package kz.aitu.myproj.service;

import kz.aitu.myproj.entity.Professor;
import kz.aitu.myproj.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public List<Professor> getAll() {
        return repo.findAll();
    }

    public Professor create(Professor professor) {
        return repo.save(professor);
    }

    public List<Professor> getByCourse(String course) {
        return repo.findByCourse(course);
    }

    public Professor update(Integer id, Professor newData) {
        Professor existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("prof not found"));

        existing.setName(newData.getName());
        existing.setCourse(newData.getCourse());
        existing.setAge(newData.getAge());

        return repo.save(existing);
    }
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("professor not found");
        }
        repo.deleteById(id);
    }

}
