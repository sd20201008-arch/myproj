package kz.aitu.myproj.controller;

import kz.aitu.myproj.entity.OfflineCourse;
import kz.aitu.myproj.service.OfflineCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offlinecourses")
public class OfflineCourseController {

    private final OfflineCourseService service;

    public OfflineCourseController(OfflineCourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<OfflineCourse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OfflineCourse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfflineCourse create(@RequestBody OfflineCourse c) {
        return service.create(c);
    }

    @PutMapping("/{id}")
    public OfflineCourse update(@PathVariable Integer id, @RequestBody OfflineCourse c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

