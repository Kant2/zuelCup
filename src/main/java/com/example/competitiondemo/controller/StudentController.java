package com.example.competitiondemo.controller;

import com.example.competitiondemo.enums.GenderEnum;
import com.example.competitiondemo.pojo.Student;
import com.example.competitiondemo.service.StudentService;
import com.example.competitiondemo.util.result.Result;
import com.example.competitiondemo.util.result.ResultGenerator;
import com.example.competitiondemo.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    // 不能简单的返回对象，需要封装为“结果对象”

    @Autowired
    private StudentService service;

    /**
     * 查询（单个student）
     *
     * @param id 学生Id
     * @return 学生view object对象
     */
    @GetMapping("/student/{id}")
    public Result<Student> getStudent(@PathVariable("id") String id) {
        return ResultGenerator.getSuccessResult(service.findById(id));
    }

    /**
     * 查询（所有student）
     *
     * @return 学生view object集合
     */
    @GetMapping("/students")
    public Result<List<Student>> getStudents() {
        List<Student> students = service.findAll();
        return ResultGenerator.getSuccessResult(students);
    }

    // 需不需要根据条件查询？还是前端直接完成？

    /**
     * 创建（新student）（& 修改student？）
     *
     * @param studentVO 学生view object对象
     * @return student view object对象
     */
    @PostMapping("/student")
    public StudentVO insertStudent(@RequestBody StudentVO studentVO) {
//        return changeToVO(repository.save(changeToPojo(studentVO)));
        return null;
    }

    // 需不需要删除用户 & 禁用用户（增加available字段）

    /**
     * Pojo ——> View Object
     *
     * @param student pojo对象
     * @return vo对象
     */
    private StudentVO changeToVO(Student student) {
        return null;
    }

    /**
     * View Object ——> Pojo
     *
     * @param studentVO vo对象
     * @return pojo对象
     */
    private Student changeToPojo(StudentVO studentVO) {
//        Student student = new Student();
//        student.setSName(studentVO.getName());
//        student.setSGender(GenderEnum.getEnumByName(studentVO.getGenderName()));
        return null;
//        return student;
    }
}
