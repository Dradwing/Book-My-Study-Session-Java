package com.ashutosh.business;

import com.ashutosh.DAO.StudentDAO;

import com.ashutosh.bean.Student;
import com.ashutosh.bean.User;
import java.util.*;

public class StudentService extends UserService {
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAllStudents();
    }

    public Student getStudentById(int studentId) {
        return studentDAO.findStudentById(studentId);
    }

    public Student addStudent(Student student) {
        User studentUser =new User();

        studentUser.setEmailId(student.getEmailId());
        studentUser.setPassword(student.getPassword());
        studentUser.setPhoneNumber(student.getPhoneNumber());
        studentUser.setUserName(student.getUserName());
        studentUser.setRole(User.Role.Student);
        student.setRole(User.Role.Student);

        return studentDAO.addStudent(studentUser, student);
    }
}
