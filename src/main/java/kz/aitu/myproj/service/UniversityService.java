package kz.aitu.myproj.service;

import kz.aitu.myproj.entity.Professor;
import kz.aitu.myproj.entity.University;
import kz.aitu.myproj.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository repo;
    public UniversityService(UniversityRepository repo) {
        this.repo = repo;
    }
    public List<University> getAll() {
        return repo.findAll();
    }
    public University create(University university) {
        return repo.save(university);
    }

    public University update(Integer id, University newData) {
       University existing = repo.findById(id)
               .orElseThrow(() -> new RuntimeException("uni not found"));
                existing.setId(newData.getId());
                existing.setName(newData.getName());
                existing.setReccomend(newData.getReccomend());

                return repo.save(existing);
   }

   public void delete(Integer id) {
        repo.deleteById(id);
   }
}
