package org.example.chapter13;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score= score;
    }
}

public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("John", 85);
        Student student2 = new Student("Jane", 92);
        Student student3 = new Student("Tom", 78);
        Student student4 = new Student("Emily", 95);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);




        for (Student student : students) {
            if ( student.score >= 90) {
                System.out.println(student.name);
            }
        }
    }
}