package com.bhavya.gradesystem.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Student Grade Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        StudentTablePanel tablePanel = new StudentTablePanel();
        JButton addStudentBtn = new JButton("Add Student");
        addStudentBtn.addActionListener(e -> {
            AddStudentForm form = new AddStudentForm();
            form.setVisible(true);
        });
        JPanel topPanel = new JPanel();
        topPanel.add((addStudentBtn));

        add(topPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
    }
}