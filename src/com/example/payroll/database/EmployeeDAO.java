package com.example.payroll.database;

import com.example.payroll.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class EmployeeDAO {
    public static ResultSet getAllEmployees() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM employees";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
}