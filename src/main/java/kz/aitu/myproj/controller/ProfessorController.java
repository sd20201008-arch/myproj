package kz.aitu.myproj.controller;

import kz.aitu.myproj.entity.Professor;
import kz.aitu.myproj.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return service.create(professor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Professor>  update(@PathVariable Integer id, @RequestBody Professor professor) {
        Professor updated = service.update(id, professor);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}