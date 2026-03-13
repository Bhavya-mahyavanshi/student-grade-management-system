package com.bhavya.gradesystem.ui;

import com.bhavya.gradesystem.dao.StudentDAO;
import com.bhavya.gradesystem.model.Student;

import javax.swing.*;
import java.awt.*;

public class AddStudentForm extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField majorField;

    public AddStudentForm() {
        setTitle("Add Student");
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nameLable = new JLabel("Name:");
        JLabel emailLable = new JLabel("Email:");
        JLabel majorLable = new JLabel("Major:");

        nameField = new JTextField();
        emailField = new JTextField();
        majorField = new JTextField();

        JButton saveButton = new JButton("Save Student");

        saveButton.addActionListener(e -> saveStudent());

        add(nameLable);
        add(nameField);

        add(emailLable);
        add(emailField);

        add(majorLable);
        add(majorField);

        add(new JLabel());
        add(saveButton);
    }

    public void saveStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        String major = majorField.getText();

        Student student = new Student(name, email, major);

        StudentDAO dao = new StudentDAO();
        dao.addStudent(student);

        JOptionPane.showMessageDialog(this, "Student Added Successfully!");

        nameField.setText("");
        emailField.setText("");
        majorField.setText("");
    }
}