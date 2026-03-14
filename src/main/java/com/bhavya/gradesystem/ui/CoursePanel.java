package com.bhavya.gradesystem.ui;

import com.bhavya.gradesystem.dao.CourseDAO;
import com.bhavya.gradesystem.model.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CoursePanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public CoursePanel() {
        setLayout(new BorderLayout());

        String[] columns = {"ID", "Course Name", "Credits"};

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton addCourseBtn = new JButton("Add Course");
        addCourseBtn.addActionListener(e->addCourse());

        JPanel top = new JPanel();
        top.add(addCourseBtn);

        add(top, BorderLayout.NORTH);
        loadCourses();
    }

    private void loadCourses() {
        CourseDAO dao = new CourseDAO();
        List<Course> courses = dao.getAllCourses();
        model.setRowCount(0);

        for(Course c : courses) {
            model.addRow(new Object[] {
                    c.getId(),
                    c.getName(),
                    c.getCredits()
            });
        }
    }

    private void addCourse() {
        String name = JOptionPane.showInputDialog("Course Name");
        String creditStr = JOptionPane.showInputDialog("Credits");
        int credits = Integer.parseInt(creditStr);
        Course course = new Course(name, credits);

        CourseDAO dao = new CourseDAO();
        dao.addCourse(course);
        loadCourses();
    }
}
