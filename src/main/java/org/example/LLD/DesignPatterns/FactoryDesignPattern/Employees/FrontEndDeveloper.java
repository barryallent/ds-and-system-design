package org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees.Employee;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FrontEndDeveloper implements Employee {
    int salary;

    int employeeId;

    String employeeName;

    @Override
    public int calculateHours() {
        System.out.println("i am a frontend developer");
        return 150;
    }
}
