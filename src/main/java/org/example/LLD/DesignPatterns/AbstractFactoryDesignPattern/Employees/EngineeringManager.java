package org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.Employee;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EngineeringManager implements Employee {
    int salary;

    int employeeId;

    String employeeName;

    @Override
    public int calculateHours() {
        System.out.println("i am a engineering manager");
        return 100;
    }
}
