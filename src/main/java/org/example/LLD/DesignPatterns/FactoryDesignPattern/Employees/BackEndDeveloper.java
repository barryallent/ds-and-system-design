package org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees;

import lombok.Data;

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
