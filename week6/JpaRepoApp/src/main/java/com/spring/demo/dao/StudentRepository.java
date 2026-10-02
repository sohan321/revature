package com.spring.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.demo.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByLastName(String lastName);

    List<Student> findBySchool_Name(String name);

    Page<Student> findAll(Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.email LIKE '%@gmail.com' ORDER BY s.lastName")
    List<Student> findGmailStudents();
}
