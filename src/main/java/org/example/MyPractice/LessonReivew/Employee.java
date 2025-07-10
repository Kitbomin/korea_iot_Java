package org.example.MyPractice.LessonReivew;

public class Employee {

    private final String employeeId;
    private String name;
    private String position;
    private int salary;

    Employee(String employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;

    }




    public int getSalary () {return salary;}
    public void setSalary (int salary) {
        if (salary < 0) {
            System.out.println("유효 ㄴㄴ");
        }
    }

}
