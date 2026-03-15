package com.bhavya.gradesystem.dao;

import com.bhavya.gradesystem.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GradeDAO {
    public void addGrade(int studentId, int courseId, double grade){
        String sql = "INSERT INTO grades(student_id, course_id, grade) VALUES (?,?,?)";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.setDouble(3, grade);

            stmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
