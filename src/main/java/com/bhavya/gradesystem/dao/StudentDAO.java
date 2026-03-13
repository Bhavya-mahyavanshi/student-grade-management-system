package com.bhavya.gradesystem.dao;

import com.bhavya.gradesystem.db.DatabaseConnection;
import com.bhavya.gradesystem.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try(Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setMajor(rs.getString("major"));

                students.add(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return students;
    }
}