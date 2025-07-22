package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. 컬렉션 프레임워크 사용
 * 2. 스트림 API
 * 3. 람다 표현식 & 메서드 참조
 *
 * == 학생 관리 시스템 ==
 * : 학생 목록 필터링 & 정렬
 *
 * filter
 * -> 조건에 부합하는지 확인 -> 결과값의 개수가 달라질 수 있음
 *
 * map
 * -> 기존의 개수와 차이가 안남
 *
 */

@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade; //학점
}


public class J_Practice {
    public static void main(String[] args) {
        List<StudentClass> studentClasses = Arrays.asList(
                new StudentClass("오신혁", 25, 4.3),
                new StudentClass("김세훈", 30, 4.1),
                new StudentClass("권민현", 27, 4.0),
                new StudentClass("안미향", 29, 3.8),
                new StudentClass("김태양", 20, 3.9)
        );

        // 1) 학점이 4.0 이상인 학생 필터링
        List<StudentClass> filteredStudent = studentClasses.stream()
                .filter(student -> student.getGrade() >= 4.0)
                .collect(Collectors.toList());

        //Collectors.toList()
        //: static 메서드
        // - 스트림을 List 타입으로 변환시켜줌

        System.out.println("학점이 4.0 이상인 학생: ");
        filteredStudent.forEach(System.out::println);


        // 2) 학생 이름 목록만 추출
        List<String> studentNames =
                studentClasses.stream()
//                        .map(student -> student.getName()) => 인스턴스 메서드 참조
                        .map(StudentClass::getName)
                        .collect(Collectors.toList());
        System.out.println("학생 이름 목록");
        System.out.println(studentNames);



        // 3) 학생들을 점수 순으로 정렬
        // : 스트림 API 중간 연산의 sorted()
        // >> Comparator 클래스의 .comparing 타입 정적 메서드를 활용
        List<StudentClass> sortedStudents =
                studentClasses.stream()
                        //ClassCastException: 오류 발생 -> sorted는 클래스 객체 형식으로 비교할 수 없다.
                        //sorted() : String, Integer 등은 기본 정렬이 정의되어 있어 사용가능함
//                        .sorted(Comparator.comparingDouble(s -> s.getGrade())) 아래처럼 바꾸면 더 좋음
//                        .sorted(Comparator.comparingDouble(StudentClass::getGrade)) //이건 오름차순
                        .sorted(Comparator.comparingDouble(StudentClass::getGrade).reversed()) //이건 내림차순 .reversed()써서 => 근데 이건 Comparator 쓸때만
                        .collect(Collectors.toList());
        System.out.println("점수 순으로 정렬된 학생");
        sortedStudents.forEach(System.out::println);

        

        // 4) 학생들 중 이름에 '민' 자가 포함된 학생 필터링
        List<StudentClass> studentsWithMin =
                studentClasses.stream()
                        .filter(studentClass -> studentClass.getName().contains("민"))
                        .collect(Collectors.toList());

        System.out.println("이름에 민이 들어간 학생");
        studentsWithMin.forEach(System.out::println);

    }
}
