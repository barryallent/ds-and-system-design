package org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Factories;

import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.Employee;

public class EmployeeProducer {
    public static Employee getEmployee(EmployeeFactory e1, String employeeType ) {
        return e1.createEmployee(employeeType);
    }
}
