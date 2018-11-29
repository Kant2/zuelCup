package com.example.competitiondemo.service;

import com.example.competitiondemo.pojo.Student;

import java.util.List;

public interface StudentService {

    Student findById(String sId);
    List<Student> findAll();
    Student save(Student student);

}
