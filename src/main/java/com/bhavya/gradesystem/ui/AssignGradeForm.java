package com.bhavya.gradesystem.ui;

import com.bhavya.gradesystem.dao.GradeDAO;

import javax.swing.*;
import java.awt.*;

public class AssignGradeForm extends JFrame {
    private JTextField studentIdField;
    private JTextField courseIdField;
    private JTextField gradeField;

    public AssignGradeForm() {
        setTitle("Assign Grade");
        setSize(350, 250);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2, 10, 10));

        studentIdField = new JTextField();
        courseIdField = new JTextField();
        gradeField = new JTextField();

        JButton saveBtn = new JButton("Save Grade");

        saveBtn.addActionListener(e -> saveGrade());

        add(new JLabel("Student ID"));
        add(studentIdField);

        add(new JLabel(("Course ID")));
        add(courseIdField);

        add(new JLabel("Grade"));
        add(gradeField);

        add(new JLabel());
        add(saveBtn);
    }

    private void saveGrade() {
        int studentId = Integer.parseInt(studentIdField.getText());
        int courseId = Integer.parseInt(courseIdField.getText());
        double grade = Double.parseDouble(gradeField.getText());

        GradeDAO dao = new GradeDAO();
        dao.addGrade(studentId, courseId, grade);

        JOptionPane.showMessageDialog(this, "Grade Saved");

        dispose();
    }
}
