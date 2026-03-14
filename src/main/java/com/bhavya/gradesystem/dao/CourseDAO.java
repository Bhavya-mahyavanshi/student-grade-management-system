package com.bhavya.gradesystem.dao;

import com.bhavya.gradesystem.db.DatabaseConnection;
import com.bhavya.gradesystem.model.Course;

import java.sql.*;
import java.util.*;

public class CourseDAO {
    public void addCourse(Course course) {
        String sql = "INSERT INTO courses(name, credits) VALUES(?, ?)";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getCredits());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM courses";

        try(Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course c = new Course();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setCredits(rs.getInt("credits"));

                courses.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return courses;
    }
}
