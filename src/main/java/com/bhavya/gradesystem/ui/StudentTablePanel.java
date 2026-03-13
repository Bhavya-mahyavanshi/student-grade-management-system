package com.bhavya.gradesystem.ui;

import com.bhavya.gradesystem.dao.StudentDAO;
import com.bhavya.gradesystem.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StudentTablePanel extends JPanel{
    private JTable table;
    private DefaultTableModel model;

    public StudentTablePanel() {
        setLayout(new BorderLayout());
        String[] columns = {"ID", "Name", "Email", "Major"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        loadStudents();
    }

    public void loadStudents() {
        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudents();
        model.setRowCount(0);

        for(Student s : students){
            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getEmail(),
                    s.getMajor()
            });
        }
    }
}
