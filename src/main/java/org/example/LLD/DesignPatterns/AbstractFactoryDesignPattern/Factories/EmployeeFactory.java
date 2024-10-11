package org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Factories;

import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.Employee;

public interface EmployeeFactory {
    Employee createEmployee(String employeeType);
}
