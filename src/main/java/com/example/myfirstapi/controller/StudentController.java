package com.example.myfirstapi.controller;

import com.example.myfirstapi.model.Student;
import com.example.myfirstapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Iterable<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student studentToBeAdded) {
        this.studentService.addStudent(studentToBeAdded);
    }

    @DeleteMapping("/students/{idOfStudentToBeRemoved}")
    public void removeStudent(@PathVariable Long idOfStudentToBeRemoved) {
        this.studentService.removeStudent(idOfStudentToBeRemoved);
    }

    @PutMapping("/students/{idOfStudentToBeUpdated}")
    public void updateStudent(@PathVariable Long idOfStudentToBeUpdated, @RequestBody Student studentToReplaceWith) {
        this.studentService.updateStudent(idOfStudentToBeUpdated, studentToReplaceWith);
    }
}
