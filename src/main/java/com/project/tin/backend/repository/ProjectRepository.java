package com.project.tin.backend.repository;

import com.project.tin.backend.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT COALESCE((MAX(id) + 1), 1) FROM Project")
    Integer generateNextId();

    List<Project> findBySubjectId(int id);
}
