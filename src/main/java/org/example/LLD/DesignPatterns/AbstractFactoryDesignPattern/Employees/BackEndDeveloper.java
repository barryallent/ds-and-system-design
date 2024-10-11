package org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees;

import lombok.Data;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.Employee;

@Data
public class BackEndDeveloper implements Employee {
    int salary;

    int employeeId;

    String employeeName;


    @Override
    public int calculateHours() {
        System.out.println("i am a backend developer");
        return 210;
    }
}
