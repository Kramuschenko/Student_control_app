package com.project.tin.frontend;

import com.project.tin.backend.Student;
import com.project.tin.dto.StudentDto;
import com.project.tin.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/id/{id}")
    public StudentDto getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public void createStudent(@RequestBody StudentDto studentDto) {
        studentService.createStudent(studentDto);
    }

    @PostMapping("/student/update")
    public void updateStudent(@RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/student/id/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
}
