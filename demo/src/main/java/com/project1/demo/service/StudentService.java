package com.project1.demo.service;

import com.project1.demo.data.entity.Student;
import com.project1.demo.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void AddStudent(Student student){
        studentRepository.save(student);



    }

}
