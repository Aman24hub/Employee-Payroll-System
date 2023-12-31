CREATE DATABASE employee_payroll;

USE employee_payroll;
--emptable
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id VARCHAR(20) UNIQUE,
    name VARCHAR(100),
    position VARCHAR(50),
    department VARCHAR(50),
    salary DOUBLE
);

--empdata
INSERT INTO employees (employee_id, name, position, department, salary)
VALUES
    ('EMP001', 'John Doe', 'Manager', 'Sales', 60000.00),
    ('EMP002', 'Jane Smith', 'Developer', 'IT', 55000.00),
    ('EMP003', 'Michael Johnson', 'HR Manager', 'HR', 58000.00);
    
SELECT * FROM employees;
