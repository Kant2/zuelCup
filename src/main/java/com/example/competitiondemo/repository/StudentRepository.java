package com.example.competitiondemo.repository;

import com.example.competitiondemo.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, String> {

    Boolean existsBySId(String id);
}
