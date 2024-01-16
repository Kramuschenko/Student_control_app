package com.project.tin.frontend;

import com.project.tin.backend.Grade;
import com.project.tin.dto.GradeDto;
import com.project.tin.dto.StudentDto;
import com.project.tin.service.GradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/grade")
    public Page<GradeDto> getAllGrades(@RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return gradeService.getAllGrades(pageable);
    }

    @GetMapping("/grade/id/{id}")
    public GradeDto getGrade(@PathVariable("id") int id) {
        return gradeService.getGradeById(id);
    }

    @PostMapping("/grade")
    public void createGrade(@RequestBody GradeDto gradeDto) {
        gradeService.createGrade(gradeDto);
    }

    @PostMapping("/grade/update")
    public void updateGrade(@RequestBody GradeDto gradeDto) {
        gradeService.updateGrade(gradeDto);
    }

    @DeleteMapping("/grade/id/{id}")
    public void deleteGrade(@PathVariable("id") int id) {
        gradeService.deleteGrade(id);
    }
}
