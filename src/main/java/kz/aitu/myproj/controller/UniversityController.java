package kz.aitu.myproj.controller;

import kz.aitu.myproj.entity.University;
import kz.aitu.myproj.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService service;
    public UniversityController(UniversityService service) {
        this.service = service;
    }
    @GetMapping
    public List<University> findAll() {
        return service.getAll();
    }

    @PostMapping
    public University create(@RequestBody University university) {
        return service.create(university);
    }

    @PutMapping("/{id}")
    public ResponseEntity<University> update(@PathVariable Integer id, @RequestBody University university) {
        University updated = service.update(id, university);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
