package com.example.payroll.gui;
import com.example.payroll.database.EmployeeDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.example.payroll.database.DatabaseConnection;

public class PayrollSystemGUI {
    private JFrame frame;
    private JTable table;
    private JButton loadDataButton;

    public void display() {
        // Create and set up the frame
        frame = new JFrame("Employee Payroll System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the table
        String[] columnNames = {"Employee ID", "Name", "Position", "Department", "Salary"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        // Create the button
        loadDataButton = new JButton("Load Employee Data");

        // Add action listener to the button
        loadDataButton.addActionListener(e -> loadData());

        // Set the layout
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(loadDataButton, BorderLayout.SOUTH);

        // Set the frame visible
        frame.setVisible(true);
    }

    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);  // Clear previous data

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getString("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                });
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
