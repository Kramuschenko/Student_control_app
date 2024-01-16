package com.project.tin.frontend;

import com.project.tin.backend.Project;
import com.project.tin.backend.Subject;
import com.project.tin.dto.ProjectDto;
import com.project.tin.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@CrossOrigin(maxAge = 3600)
public class ProjectController {

    private final ProjectService projectService;


    @GetMapping("/project")
    public Page<Project> getAllProjects(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return projectService.getAllProjects(page, size);
    }

    @GetMapping("/project/empty")
    public List<Project> getEmptyProjects() {
        return projectService.getEmptyProjects();
    }

    @GetMapping("/project/empty/{id}")
    public List<Project> getEmptyProjectsWithId(@PathVariable("id") int id) {
        return projectService.getEmptyProjectsWithId(id);
    }

    @GetMapping("/project/id/{id}")
    public ProjectDto getSubject(@PathVariable("id") int id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/project")
    public void createProject(@RequestBody ProjectDto projectDto) {
        projectService.createProject(projectDto);
    }

    @PostMapping("/project/update")
    public void updateProject(@RequestBody ProjectDto projectDto) {
        projectService.updateProject(projectDto);
    }

    @DeleteMapping("/project/id/{id}")
    public void deleteProject(@PathVariable("id") int id) {
        projectService.deleteProject(id);
    }
}
