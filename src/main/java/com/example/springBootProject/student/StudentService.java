package com.example.springBootProject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private  final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> fetchStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if(studentOptional.isPresent()){
        throw new IllegalStateException("Email already in use");
    }
    studentRepository.save(student);

    }


    public  void deleteStudent(Long studentId){
      boolean isExist =  studentRepository.existsById(studentId);

      if(!isExist){
          throw new IllegalStateException("Student does not exist");
      }

      studentRepository.deleteById(studentId);

    }


}
