package com.spring.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

// what the client sends to sign a student up for a course
// the client only sends ids - the service looks up the real entities
public class EnrollmentWriteDto {

    @NotNull
    @JsonProperty("student_id")
    private Integer studentId;

    @NotNull
    @JsonProperty("course_id")
    private Integer courseId;

    // optional - a brand new enrollment usually has no grade yet
    private String grade;

    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
