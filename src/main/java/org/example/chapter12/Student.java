package org.example.chapter12;
// 학생관리시스템 모델


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String studentNumber;
    private LocalDateTime createdAt; // date값은 요청안함

    public Student(int studentId, String name, int age, String studentNumber){
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.createdAt = LocalDateTime.now();
    }


    //getter

    public int getStudentId() {return studentId;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getStudentNumber() {return studentNumber;}
    public LocalDateTime getCreatedAt() {return createdAt;}

    //setter(앵간하면 수정을 위한 값들을 설정)

    public void setName(String name) {this.name = name;}
    public void setAge(int age){this.age = age;}


    @Override
    public String toString() {
        return "Student { " +
                "ID = " + studentId +
                "AGE = " + age +
                "Number = " + studentNumber +
                "CreatedAT = " + createdAt + " }" ;

    }
}
