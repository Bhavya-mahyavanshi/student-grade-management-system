package com.bhavya.gradesystem.dao;

import com.bhavya.gradesystem.db.DatabaseConnection;
import com.bhavya.gradesystem.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {
    public void addStudent(Student student) {
        String sql = "INSERT INTO Students(name, email, major) VALUES(?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getMajor());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}