package com.spring.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.demo.domain.Course;
import com.spring.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final StudentService studentService;

    public CourseController(StudentService studentService) {
        this.studentService = studentService;
    }

    // POST http://localhost:8080/api/courses
    // { "name": "Java 101" }
    @PostMapping
    public ResponseEntity<Course> insertCourse(@Valid @RequestBody Course course) {

        Course savedCourse = studentService.insertCourse(course);

        return ResponseEntity
            .created(
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedCourse.getId())
                    .toUri()
            )
            .body(savedCourse);
    }

    // GET http://localhost:8080/api/courses/1
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return studentService.getCourseById(id);
    }
}
