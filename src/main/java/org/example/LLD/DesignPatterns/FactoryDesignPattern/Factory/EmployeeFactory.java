package org.example.LLD.DesignPatterns.FactoryDesignPattern.Factory;

import org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees.BackEndDeveloper;
import org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees.Employee;
import org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees.FrontEndDeveloper;

public class EmployeeFactory {

    public static Employee getEmployee(String employeeType) {
        if(employeeType.equalsIgnoreCase("frontend")) {
            return new FrontEndDeveloper();
        }
        if(employeeType.equalsIgnoreCase("backend")) {
            return new BackEndDeveloper();
        }
        return null;
    }
}
