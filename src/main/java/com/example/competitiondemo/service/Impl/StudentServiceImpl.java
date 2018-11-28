package com.example.competitiondemo.service.Impl;

import com.example.competitiondemo.pojo.Student;
import com.example.competitiondemo.repository.StudentRepository;
import com.example.competitiondemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public Student findById(String uId) {
        return repository.findById(uId).get();
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

}
