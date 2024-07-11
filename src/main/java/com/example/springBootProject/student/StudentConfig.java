package com.example.springBootProject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return  args -> {
        Student osman =   new Student(1,"Osmancan","osmancan@gmail.com", LocalDate.of(2000,10,30));
        Student suat =     new Student(2,"Suat","suat@gmail.com", LocalDate.of(1997,8,10))   ;

        studentRepository.saveAll(List.of(osman,suat));

        };
    }
}
