package com.project.tin.service;

import com.project.tin.backend.Grade;
import com.project.tin.backend.Project;
import com.project.tin.backend.Student;
import com.project.tin.backend.repository.GradeRepository;
import com.project.tin.backend.repository.ProjectRepository;
import com.project.tin.backend.repository.StudentRepository;
import com.project.tin.dto.GradeDto;
import com.project.tin.dto.StudentDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.project.tin.frontend.UserController.getCurrentUser;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StudentService {
    private final GradeRepository gradeRepository;

    private final StudentRepository studentRepository;
    private final ProjectRepository projectRepository;

    public Page<Student> getAllStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
    }

    public StudentDto getStudentById(Integer id) {

        return studentRepository.findById(id).map(
                student -> {
                    List<Grade> grades = student.getGrades();
                    List<GradeDto> gradeDtos = gradeToDto(grades);
                    return new StudentDto(student.getId(), student.getName(), student.getSurname(), gradeDtos, student.getCreatedAt(), student.getModifiedAt());
                }
        ).orElse(null);
    }

    private List<GradeDto> gradeToDto(List<Grade> grades) {
        return grades.stream()
                .map(grade -> {
                    Project project1 = projectRepository.getReferenceById(grade.getProjectId());
                    Student student = studentRepository.getReferenceById(grade.getStudentId());
                    return new GradeDto(grade.getId(), grade.getGrade(), grade.getProjectId(), grade.getStudentId(), grade.getCreatedAt(), grade.getModifiedAt(), student.getName(), student.getSurname(), project1.getName());
                })
                .toList();
    }

    public void createStudent(StudentDto studentDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Student student = new Student();
        student.setId(studentRepository.generateNextId());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        studentRepository.save(student);
    }

    public void updateStudent(StudentDto studentDto) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Student student = studentRepository.findById(studentDto.getId()).orElse(null);
        if (student != null) {
            student.setName(studentDto.getName());
            student.setSurname(studentDto.getSurname());
            studentRepository.save(student);
        }
    }

    @Transactional
    public void deleteStudent(int id) {
        if (Objects.isNull(getCurrentUser()))
            return;
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            gradeRepository.deleteAllByStudentId(id);

            studentRepository.delete(student);
        }
    }
}