package com.ashutosh.business;

import com.ashutosh.DAO.StudentDAO;

import com.ashutosh.bean.Student;
import com.ashutosh.bean.User;

public class StudentService {

    private StudentDAO studentDao=new StudentDAO();

    public Student registerStudent(Student student) {

        User studentUser =new User();

        studentUser.setEmailId(student.getEmailId());
        studentUser.setPassword(student.getPassword());
        studentUser.setPhoneNumber(student.getPhoneNumber());
        studentUser.setUserName(student.getUserName());
        studentUser.setRole(User.Role.Student);

        studentDao.addUser(studentUser);
        return studentDao.addStudent(studentUser, student);
    }







}
