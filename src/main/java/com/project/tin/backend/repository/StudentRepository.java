package com.project.tin.backend.repository;

import com.project.tin.backend.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT COALESCE((MAX(id) + 1), 1) FROM Student ")
    Integer generateNextId();
}
