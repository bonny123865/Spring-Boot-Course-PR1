package com.demo_0627_ThreeLevel_RE.controller;

import com.demo_0627_ThreeLevel_RE.model.Student;
import com.demo_0627_ThreeLevel_RE.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public String insert(@RequestBody Student student){
        studentService.insert(student);
        return "執行 INSERT sql";
    }

    @PostMapping("/students/batch")
    public String insertlist(@RequestBody List<Student> studentList){
        studentService.batchInsert(studentList);
        return "執行一批 INSERT SQL";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){
        studentService.deleteById(studentId);
        return "執行 DELETE sql";
    }

    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId){

        return   studentService.getById(studentId);
    }

}

