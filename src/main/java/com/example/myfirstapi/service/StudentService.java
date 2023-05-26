package com.example.myfirstapi.service;

import com.example.myfirstapi.model.Student;
import com.example.myfirstapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
   @Autowired
   private StudentRepository studentRepository;

   public Iterable<Student> getStudents() {
       return this.studentRepository.findAll();
   }

   public void addStudent(Student studentToBeAdded) {
       this.studentRepository.save(studentToBeAdded);
   }

   public void removeStudent(Long idOfStudentToBeRemoved) {
       for (Student studentToBeRemoved : this.studentRepository.findAll()) {
           if (studentToBeRemoved.getId().equals(idOfStudentToBeRemoved)) {
               this.studentRepository.delete(studentToBeRemoved);
               break;
           }
       }
   }

   public void updateStudent(Long idOfStudentToBeUpdated, Student studentToReplaceWith) {
       for (Student studentToBeEdited : this.studentRepository.findAll()) {
           if (studentToBeEdited.getId().equals(idOfStudentToBeUpdated)) {
               studentToBeEdited.setName(studentToReplaceWith.getName());
               studentToBeEdited.setPicture(studentToReplaceWith.getPicture());
               this.studentRepository.save(studentToBeEdited);
               break;
           }
       }
   }
}
