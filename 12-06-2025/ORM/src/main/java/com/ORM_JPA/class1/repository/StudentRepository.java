package com.ORM_JPA.class1.repository;

import com.ORM_JPA.class1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}