package com.demo_0627_ThreeLevel_RE.service;

import com.demo_0627_ThreeLevel_RE.model.Student;
import java.util.List;

public interface StudentService {
    Student getById(Integer studentId);

    void insert(Student student);

    void batchInsert(List<Student> studentList);

    void deleteById(Integer studentId);
}
