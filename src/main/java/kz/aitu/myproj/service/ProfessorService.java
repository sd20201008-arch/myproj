package kz.aitu.myproj.service;

import kz.aitu.myproj.entity.Professor;
import kz.aitu.myproj.entity.University;
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


    public Professor update(Integer id, Professor newData) {
        Professor existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("prof not found"));

        existing.setProfessorName(newData.getProfessorName());
        existing.setProfessorCourse(newData.getProfessorCourse());
        existing.setProfessorAge(newData.getProfessorAge());
        existing.setUniversity(newData.getUniversity());


        return repo.save(existing);
    }
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("professor not found");
        }
        repo.deleteById(id);
    }

}
