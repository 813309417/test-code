package com.xuxincheng.service;

import com.xuxincheng.bean.Student;

import java.util.List;

public interface StudentService {
    int getAllStudent();
    List<Student> getAllStudentList();

    int addStudent(Student student);
}
