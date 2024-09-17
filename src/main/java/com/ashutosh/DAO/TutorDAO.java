package com.ashutosh.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ashutosh.bean.*;

public class TutorDAO extends UserDAO {

    public Tutor addTutor(User user, Tutor tutor) {
        // First add user (as a tutor)
        addUser(user);
        tutor.setTutorId(user.getUserId());

        String sql = "INSERT INTO Tutors (tutorId, aadharCardNumber, imageURL) VALUES (?, ?, ?)";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tutor.getTutorId());
            stmt.setString(2, tutor.getAadharCardNumber());
            stmt.setString(3, tutor.getImageURL());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tutor;
    }

    public List<Tutor> findAllTutors() {
        String sql = "SELECT * FROM Tutors t JOIN Users u ON t.tutorId = u.userId";
        List<Tutor> tutors = new ArrayList<>();

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tutor tutor = new Tutor();
                tutor.setTutorId(rs.getInt("tutorId"));
                tutor.setUserName(rs.getString("userName"));
                tutor.setAadharCardNumber(rs.getString("aadharCardNumber"));
                tutor.setImageURL(rs.getString("imageURL"));
                tutor.setEmailId(rs.getString("emailId"));
                tutor.setPhoneNumber(rs.getString("phoneNumber"));

                tutors.add(tutor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tutors;
    }

    public Tutor findTutorById(int tutorId) {
        String sql = "SELECT * FROM Tutors t JOIN Users u ON t.tutorId = u.userId WHERE t.tutorId = ?";
        Tutor tutor = null;

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, tutorId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tutor = new Tutor();
                tutor.setTutorId(rs.getInt("tutorId"));
                tutor.setUserName(rs.getString("userName"));
                tutor.setAadharCardNumber(rs.getString("aadharCardNumber"));
                tutor.setImageURL(rs.getString("imageURL"));
                tutor.setEmailId(rs.getString("emailId"));
                tutor.setPhoneNumber(rs.getString("phoneNumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tutor;
    }

    public Tutor updateTutor(Tutor tutor) {
        String sql = "UPDATE Tutors SET imageURL = ? WHERE tutorId = ?";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tutor.getImageURL());
            stmt.setInt(2, tutor.getTutorId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tutor;
    }
}
