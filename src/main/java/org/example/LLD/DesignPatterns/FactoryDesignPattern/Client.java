package org.example.LLD.DesignPatterns.FactoryDesignPattern;

import org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees.Employee;
import org.example.LLD.DesignPatterns.FactoryDesignPattern.Employees.FrontEndDeveloper;
import org.example.LLD.DesignPatterns.FactoryDesignPattern.Factory.EmployeeFactory;

public class Client {
    public static void main(String[] args) {

        //****************************************just normal OOPS stuff*************************************************************
        //employee object can only access employee methods and not subclass methods
        Employee e1 = new FrontEndDeveloper();

        // e1.getSalary(); // This will give a compile-time error

        System.out.println(e1.calculateHours());

        //to access frontend developer methods you will have to typecast
        FrontEndDeveloper fed = (FrontEndDeveloper) e1;
        System.out.println(fed.getSalary());

        //*****************************************************************************************************************************


        //get objects from EmployeeFactory based on condition
        //so someone from outside can call my APIs and they can pass some string or something at runtime
        //so based on the input passed from client I have to create object at runtime.
        //Assigned it to Employee because we don't know what it will be, it can be frontend developer also and backend also
        //it is decided at runtime so that's why we are storing it in Employee
        Employee frontendEngineer = EmployeeFactory.getEmployee("frontend");
        System.out.println("hours= "+frontendEngineer.calculateHours());


        Employee backendEngineer = EmployeeFactory.getEmployee("backend");
        System.out.println("hours= "+backendEngineer.calculateHours());


        //Builder Design Pattern
        //Using @Builder annotation in className and also added @AllArgsConstructor and @NoArgsConstructor
        //sequence does not matter in this
        FrontEndDeveloper f1 = FrontEndDeveloper.builder()
                .salary(100000)
                .employeeId(1234)
                .employeeName("aakash")
                .build();
        System.out.println(f1);
    }
}
