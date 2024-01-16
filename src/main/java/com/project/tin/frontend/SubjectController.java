package com.project.tin.frontend;

import com.project.tin.backend.Subject;
import com.project.tin.backend.repository.ProjectRepository;
import com.project.tin.dto.SubjectDto;
import com.project.tin.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@CrossOrigin(maxAge = 3600)
public class SubjectController {
    private final ProjectRepository projectRepository;

    private final SubjectService subjectService;

    @GetMapping("/subject")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/subject/id/{id}")
    public Subject getSubject(@PathVariable("id") int id) {
        Subject subject = subjectService.getSubjectById(id);
        subject.setProjects(projectRepository.findBySubjectId(id));

        return subject;
    }

    @PostMapping("/subject")
    public ResponseEntity<String> createSubject(@RequestBody SubjectDto subject) {
        subjectService.createSubject(subject);

        String answer = "Subject: " + "added";
        log.info("Success: " + answer);
        log.debug("Saved or updated: " + subject);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PostMapping("/subject/update")
    public ResponseEntity<String> updateSubject(@RequestBody SubjectDto subject) {
        subjectService.updateSubject(subject);

        String answer = "Subject: " + "updated";
        log.info("Success: " + answer);
        log.debug("Saved or updated: " + subject);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @DeleteMapping("/subject/id/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") int id) {
        log.info("Subject {} will be deleted", id);
        subjectService.deleteSubject(id);
        return new ResponseEntity<>("Subject deleted", HttpStatus.OK);
    }
}
