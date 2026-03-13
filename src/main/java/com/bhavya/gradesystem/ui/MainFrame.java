package com.bhavya.gradesystem.ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Student Grade Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JButton addStudent = new JButton("Add Student");
        add(addStudent);
    }
}