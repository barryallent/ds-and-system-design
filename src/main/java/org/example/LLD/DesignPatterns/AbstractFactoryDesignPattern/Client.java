package org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern;

import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Employees.Employee;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Factories.EmployeeProducer;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Factories.EngineerFactory;
import org.example.LLD.DesignPatterns.AbstractFactoryDesignPattern.Factories.ManagerFactory;

public class Client {
    public static void main(String[] args) {

        //this design pattern also returns objects from factory same as factory pattern
        //but there is an abstract layer in between, because we can have multiple type of factories
        //so engineer factory can return frontend backend developers, similarly manager factory can return managers.
        Employee e1 = EmployeeProducer.getEmployee(new ManagerFactory(), "engineering manager");
        System.out.println(e1.calculateHours());

        Employee e2 = EmployeeProducer.getEmployee(new EngineerFactory(), "frontend developer");
        System.out.println(e2.calculateHours() );

        Employee e3 = EmployeeProducer.getEmployee(new EngineerFactory(), "backend developer");
        System.out.println(e3.calculateHours());

    }
}
