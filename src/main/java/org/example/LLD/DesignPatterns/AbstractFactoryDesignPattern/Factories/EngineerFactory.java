package org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Factories;

import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.BackEndDeveloper;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.Employee;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.FrontEndDeveloper;

public class EngineerFactory implements EmployeeFactory{
    @Override
    public Employee createEmployee(String employeeType) {
        if(employeeType.equalsIgnoreCase("frontend developer")) {
            return new FrontEndDeveloper();
        }
        if(employeeType.equalsIgnoreCase("backend developer")) {
            return new BackEndDeveloper();
        }
        return null;
    }
}
