
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
    private JTextField searchField;

    public StudentTablePanel() {
        setLayout(new BorderLayout());
        String[] columns = {"ID", "Name", "Email", "Major"};
        model = new DefaultTableModel(columns, 0);

        searchField = new JTextField(20);
        JButton searchBtn = new JButton("Search");
        JButton clearBtn = new JButton("Clear");
        searchBtn.addActionListener(e->searchStudents());
        clearBtn.addActionListener(e->loadStudents());
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        searchPanel.add(clearBtn);
        add(searchPanel, BorderLayout.NORTH);

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JButton deletebtn = new JButton("Delete Student");
        deletebtn.addActionListener(e -> deleteStudent());
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deletebtn);
        add(bottomPanel, BorderLayout.SOUTH);

        JButton editBtn = new JButton("Edit Student");
        editBtn.addActionListener(e->editStudent());
        bottomPanel.add(editBtn);

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

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();

        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete");
            return;
        }

        int id = (int) model.getValueAt(selectedRow, 0);
        StudentDAO dao = new StudentDAO();
        dao.deleteStudent(id);

        JOptionPane.showMessageDialog(this, "Student deleted");
        loadStudents();
    }

    private void searchStudents() {
        String keyword = searchField.getText();
        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.searchStudents(keyword);
        model.setRowCount(0);

        for(Student s : students) {
            model.addRow(new Object[] {
                    s.getId(),
                    s.getName(),
                    s.getEmail(),
                    s.getMajor()
            });
        }
    }

    private void editStudent() {
        int selectedRow = table.getSelectedRow();

        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a student first");
            return;
        }

        Student student = new Student();
        student.setId((int) model.getValueAt(selectedRow, 0));
        student.setName((String) model.getValueAt(selectedRow, 1));
        student.setEmail((String) model.getValueAt(selectedRow, 2));
        student.setMajor((String) model.getValueAt(selectedRow, 3));

        EditStudentForm form = new EditStudentForm(student);
        form.setVisible(true);
    }
}
