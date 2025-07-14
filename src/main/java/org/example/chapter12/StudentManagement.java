package org.example.chapter12;

import org.example.chapter12.view.StudentView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * === 학생 관리 시스템 ===
 * : MVC 패턴 적용 + DTO
 * - 학생 데이터에 대한 CRUD 기능 적용
 *
 * 1. 요구사항 정의
 * 1) 학생 추가 기능
 * 2) 학생 전체 조회 기능
 * 3) 특정 학생 조회 기능(단건)
 * 4) 학생 수정 기능
 * 5) 학생 삭제 기능
 * 6) 프로그램 종료 기능
 *
 * 2. MVC 패턴 구성 요소
 * 1) Model(Student)
 * @Filed: 학생고유번호(studentId), 이름(name) , 나이(age), 학번(studentNumber), 생성일(createdAt)
 * @Method: getter/setter, toString
 *
 * 2) View(StudentView)
 * : 사용자와 상호작용 할 수 있는 메뉴 표시
 *      - 각 요청에 따라 controller에게 요청값과 행위를 전달하게 될 예정
 *
 * 3) Controller(StudentController)
 * : 학생 데이터를 저장(List<Student>)
 * +) 6가지 기능 수행
 *
 * 4) DTO(StudentRequestDTO(요청), StudentResponseDTO(응답))
 *
 */

public class StudentManagement {
    public static void main(String[] args) {

        List<Student> dummyStudent = new ArrayList<>();
        dummyStudent.add(new Student(1, "이승아", 25, "11111"));
        dummyStudent.add(new Student(2, "이도겸", 15, "22222"));
        dummyStudent.add(new Student(3, "조승범", 27, "33333"));
        dummyStudent.add(new Student(4, "김명진", 30, "44444"));

        // 의존성 주입
        StudentController controller = new StudentController(dummyStudent);
        Scanner sc = new Scanner(System.in);

        StudentView view = new StudentView(sc, controller);
        view.showMenu();


    }
}
