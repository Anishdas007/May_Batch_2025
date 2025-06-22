package com.ORM_JPA.class1.repository;

import com.ORM_JPA.class1.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}