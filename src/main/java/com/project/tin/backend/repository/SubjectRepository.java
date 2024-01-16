package com.project.tin.backend.repository;

import com.project.tin.backend.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query(value = "SELECT COALESCE((MAX(id) + 1), 1) FROM Subject")
    Integer generateNextId();
}
