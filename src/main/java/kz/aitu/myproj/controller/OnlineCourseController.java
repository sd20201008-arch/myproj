package kz.aitu.myproj.controller;

import kz.aitu.myproj.entity.OnlineCourse;
import kz.aitu.myproj.service.OnlineCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/onlinecourses")
public class OnlineCourseController {

    private final OnlineCourseService service;

    public OnlineCourseController(OnlineCourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<OnlineCourse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OnlineCourse getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OnlineCourse create(@RequestBody OnlineCourse c) {
        return service.create(c);
    }

    @PutMapping("/{id}")
    public OnlineCourse update(@PathVariable Integer id, @RequestBody OnlineCourse c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
