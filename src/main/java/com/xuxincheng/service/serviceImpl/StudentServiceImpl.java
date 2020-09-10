package com.xuxincheng.service.serviceImpl;

import com.xuxincheng.bean.Student;
import com.xuxincheng.bean.StudentExample;
import com.xuxincheng.dao.StudentMapper;
import com.xuxincheng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public int getAllStudent() {
        StudentExample studentExample = new StudentExample();
        return studentMapper.selectByExample(null).size();
    }

    @Override
    public List<Student> getAllStudentList() {
        StudentExample studentExample = new StudentExample();
        return studentMapper.selectByExample(null);
    }
    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }
}
