package com.demo_0627_ThreeLevel_RE.service;
import com.demo_0627_ThreeLevel_RE.model.Student;
import com.demo_0627_ThreeLevel_RE.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class StudentServiceImpl implements StudentService {

    //因為所有實現 StudentDao(使用Interface 作為變數類型) 此 Interface 的class，皆可利用「多型」，向上轉成StudentDao類型
    //所以若是要把StudentDao 改成其他新的class的話，不需要改任何東西，可以直接挪用
    //所以通常在Service、Dao層，都會建立個別的 Interface 當作變數
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);

    }

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void batchInsert(List<Student> studentList) {
        studentDao.batchInsert(studentList);
    }

    @Override
    public void deleteById(Integer studentId) {
        studentDao.deleteById(studentId);
    }
}
