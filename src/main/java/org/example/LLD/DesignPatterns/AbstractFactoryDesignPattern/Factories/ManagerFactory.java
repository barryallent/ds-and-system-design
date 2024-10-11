package org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Factories;

import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.Employee;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.EngineeringManager;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.ProductManager;

public class ManagerFactory implements EmployeeFactory{
    @Override
    public Employee createEmployee(String employeeType) {
        if(employeeType.equalsIgnoreCase("engineering manager")) {
            return new EngineeringManager();
        }
        if(employeeType.equalsIgnoreCase("product manager")) {
            return new ProductManager();
        }
        return null;
    }
}
