package com.project.tin.backend.repository;

import com.project.tin.backend.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @Query(value = "SELECT COALESCE((MAX(id) + 1), 1) FROM Grade")
    Integer generateNextId();

    List<Grade> findAllByProjectId(int id);

    void deleteAllByStudentId(int id);
}
