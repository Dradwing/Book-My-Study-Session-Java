package com.ashutosh.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ashutosh.bean.*;
import java.util.*;

public class StudentDAO extends UserDAO {

    public Student addStudent(User user, Student student) {
        // First add user (as a student)
        addUser(user);
        student.setStudentId(user.getUserId());

        String sql = "INSERT INTO Students (studentId) VALUES (?)";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getStudentId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public List<Student> findAllStudents() {
        String sql = "SELECT * FROM Students s JOIN Users u ON s.studentId = u.userId";
        List<Student> students = new ArrayList<>();

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setUserName(rs.getString("userName"));
                student.setEmailId(rs.getString("emailId"));
                student.setPhoneNumber(rs.getString("phoneNumber"));

                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student findStudentById(int studentId) {
        String sql = "SELECT * FROM Students s JOIN Users u ON s.studentId = u.userId WHERE s.studentId = ?";
        Student student = null;

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setUserName(rs.getString("userName"));
                student.setEmailId(rs.getString("emailId"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE Students SET ..."; // Add relevant fields to update

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set parameters here based on fields in Student object
            stmt.setInt(1, student.getStudentId());
            // More parameters here...

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
         }
        }