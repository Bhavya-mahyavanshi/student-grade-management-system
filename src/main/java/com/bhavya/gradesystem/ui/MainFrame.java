package com.bhavya.gradesystem.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {

        setTitle("Student Grade Management System");
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {

        setLayout(new BorderLayout());

        JPanel navBar = new JPanel();

        JButton studentsBtn = new JButton("Students");
        JButton coursesBtn = new JButton("Courses");
        JButton gradesBtn = new JButton("Grades");

        navBar.add(studentsBtn);
        navBar.add(coursesBtn);
        navBar.add(gradesBtn);

        add(navBar, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        StudentTablePanel studentPanel = new StudentTablePanel();
        CoursePanel coursePanel = new CoursePanel();

        mainPanel.add(studentPanel, "students");
        mainPanel.add(coursePanel, "courses");

        add(mainPanel, BorderLayout.CENTER);

        studentsBtn.addActionListener(e -> cardLayout.show(mainPanel,"students"));
        coursesBtn.addActionListener(e -> cardLayout.show(mainPanel,"courses"));
    }
}