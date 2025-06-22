package com.ORM_JPA.class1.repositary;

import com.ORM_JPA.class1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
