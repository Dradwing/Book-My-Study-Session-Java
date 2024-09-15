package com.ashutosh.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ashutosh.bean.*;

public class StudentDAO {

    public User addUser(User user) {

        String sql = "INSERT INTO Users (userName, role, emailId, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getEmailId());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getPassword());


            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
            {
                user.setUserId(rs.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Student addStudent(User user, Student student) {
        String sql = "INSERT INTO Students (studentId) VALUES (?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        student.setStudentId(user.getUserId());
        return student;
    }

}

