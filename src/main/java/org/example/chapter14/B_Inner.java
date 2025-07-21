package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

// === 학교 시스템 구현 === //
@Getter
@AllArgsConstructor

class School {
    private String schoolName;

    // 내부 클래스 -> 학생
    // 학생 클래스는 비정적 내부 클래스
    @AllArgsConstructor // 모든 필드를 생성자의 매개변수로 전달받아 필드의 초기값으로 지정해주는 생성자
    class Student {
        private int studentId;
        private String studentName;

        public void displayInfo() {
            System.out.println("학교명: " + schoolName + ", 학생 이름: " +studentName);
        }
    }

    // 정적 내부 클래스 -> 교장 선생님
    // singleton 사용// 전체 학교를 대표, 단 한명만 존재
    static class Principal{
        private static Principal instance;

        private Principal () {}

        public static  Principal getInstance() {
            if (instance == null) {
                instance = new Principal();
            }
            return instance;
        }

        public void displayInfo() {
            System.out.println("훈화 말씀: ~~~~~하세요");
        }
    }
}

public class B_Inner {
    public static void main(String[] args) {
        School school = new School("ㅇㅇ초등학교");

        //@롬복 어노테이션 생성자
        //: 필드 값 순서대로 매개변수 값을 설정 -> 타입에 유의할 것
        School.Student student1 = school.new Student(43, "학생 1");
        student1.displayInfo();

        //Principal 클래스
        // getInstance() 내부의 new 연산자가 new 키워드를 자동 생략 (일반 static 메서드 호출)
        School.Principal principal = School.Principal.getInstance();
        principal.displayInfo();
    }

}
