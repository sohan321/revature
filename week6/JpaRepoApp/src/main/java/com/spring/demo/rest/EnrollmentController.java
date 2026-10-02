package com.spring.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.demo.domain.Enrollment;
import com.spring.demo.dto.EnrollmentWriteDto;
import com.spring.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final StudentService studentService;

    public EnrollmentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // POST http://localhost:8080/api/enrollments
    // { "student_id": 1, "course_id": 1 }
    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@Valid @RequestBody EnrollmentWriteDto enrollment) {

        Enrollment savedEnrollment = studentService.enrollStudent(enrollment);

        return ResponseEntity
            .created(
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedEnrollment.getId())
                    .toUri()
            )
            .body(savedEnrollment);
    }

    // GET http://localhost:8080/api/enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return studentService.getAllEnrollments();
    }
}
