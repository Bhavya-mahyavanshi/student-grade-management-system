package com.bhavya.gradesystem.ui;

import com.bhavya.gradesystem.dao.StudentDAO;
import com.bhavya.gradesystem.model.Student;

import javax.swing.*;
import java.awt.*;

public class EditStudentForm extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField majorField;

    private Student student;

    public EditStudentForm(Student student) {
        this.student = student;

        setTitle("Edit Student");
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4,2,10,10));

        nameField = new JTextField(student.getName());
        emailField = new JTextField(student.getEmail());
        majorField = new JTextField(student.getMajor());

        JButton updateBtn = new JButton("Update");

        updateBtn.addActionListener(e -> updateStudent());

        add(new JLabel("Name"));
        add(nameField);

        add(new JLabel("Email"));
        add(emailField);

        add(new JLabel("Major"));
        add(majorField);

        add(new JLabel());
        add(updateBtn);
    }

    private void updateStudent() {
        student.setName(nameField.getText());
        student.setEmail(emailField.getText());
        student.setMajor(majorField.getText());

        StudentDAO dao = new StudentDAO();
        dao.updateStudent(student);

        JOptionPane.showMessageDialog(this, "Student updated");

        dispose();
    }
}
