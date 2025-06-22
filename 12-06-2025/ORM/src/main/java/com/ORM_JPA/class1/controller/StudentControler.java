package com.ORM_JPA.class1.controller;

import com.ORM_JPA.class1.dto.StudentDTO;
import com.ORM_JPA.class1.entity.Student;
import com.ORM_JPA.class1.service.StudentService;
import com.ORM_JPA.class1.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentControler {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }
}
