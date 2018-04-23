package com.wzf.service.serviceImpl;

import com.wzf.dao.StudentDao;
import com.wzf.pojo.Student;
import com.wzf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;


    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }


    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
