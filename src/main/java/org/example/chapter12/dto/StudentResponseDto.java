package org.example.chapter12.dto;

import java.time.LocalDateTime;

//응답하는 데이터

public class StudentResponseDto {
    private String name;
    private int age;
    private String studentNumber;
    private LocalDateTime createdAt; // date값은 요청안함

    public StudentResponseDto(String name,
                              int age,
                              String studentNumber,
                              LocalDateTime createdAt){
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Student { " +
                "NAME = " + name +
                "AGE = " + age +
                "Number = " + studentNumber +
                "CreatedAT = " + createdAt + " }" ;

    }
}
