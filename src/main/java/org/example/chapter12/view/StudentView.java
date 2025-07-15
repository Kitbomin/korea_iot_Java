package org.example.chapter12.view;


import org.example.chapter12.Student;
import org.example.chapter12.StudentController;
import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private final Scanner sc;
    private final StudentController controller;

    public StudentView(Scanner sc, StudentController controller) {
        this.sc = sc;
        this.controller = controller;
    }

    public void showMenu() {
        while (true) {

            try {
                System.out.println("=== 학생 관리 시스템 ===");
                System.out.println("1. 학생 추가");
                System.out.println("2. 학생 전체 조회");
                System.out.println("3. 학생 단건 조회");
                System.out.println("4. 학생 정보 수정");
                System.out.println("5. 학생 삭제");
                System.out.println("6. 프로그램 종료");
                System.out.println("메뉴를 선택해주세요 >>");

                int choice = Integer.parseInt(sc.nextLine()); //버퍼 처리 안해두 됨

                switch (choice) {
                    // switch - case 화살표 문법(Java 14이상 사용 가능)
                    // case + break 문을 대채 하여 각 case만 실행하는 문법
                    case 1 -> addStudentView();
                    case 2 -> showAllStudentsView();
                    case 3 -> showStudentByStudentNumber();
                    case 4 -> updatedStudentView();
                    case 5 -> deleteStudentView();

                    //switch - case 문의 화살표 문법에서 여러 줄 코드 작성시 {} 사용
                    case 6 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return; //해당 메서드 종료
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }

            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해야 합니다.");
            } catch (Exception e) {
                System.out.println("오류가 발생하였습니다." + e.getMessage());
            }
        }
    }

    private void addStudentView() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        System.out.print("나이: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("학번: ");
        String studentNumber = sc.nextLine();

        //DTO를 만들었으니까 써봐야지
        StudentRequestDto dto = new StudentRequestDto(name, age, studentNumber);

        //하나의 객체로 감싸서 들고오기
        controller.addStudent(dto); //요청값을 하나의 객체로 감싸서 전달(DTO: 데이터 전달을 위한 객체)
    }

    private void showAllStudentsView() {
        List<StudentResponseDto> list = controller.getAllStudents(); //요청값이 없으니까 냅다 값 다 받기

        if (list.isEmpty()) {
            // 리스트 내부 요소가 없는 경우 굳이 순회를 돌 필요가 없음
            System.out.println("등록된 학생이 없습ㄴ디ㅏ.");
        }else {
            //응답 값 가지고 와야함
            for (StudentResponseDto dto: list) {

                //dio를 toString으로 재정의 해서 그냥 들고와도 됨
                System.out.println(dto);
            }
        }
    }

    private void showStudentByStudentNumber() {
        System.out.print("조회 할 학생의 학번을 입력해주세요 >>");
        String studentNumber = sc.nextLine();

        StudentResponseDto dto = controller.getStudentById(studentNumber);

        // 왜 null이 가능한가? -> 모든 클래스타입은 Object 클래스 타입을 상속받음
        // >>> Object(참조) 타입은 기본적으로 null 값을 가지기 때문

        if (dto == null) {
            System.out.println("그 학생은 정보가 없어용 "+ studentNumber);
        }else {
            //dto 그대로 들고오기
            System.out.println(dto);
        }
    }

    private void updatedStudentView () {
        System.out.print("수정할 학생 학번 입력: ");
        String studentNumber = sc.nextLine();

        System.out.print("새 이름: ");
        String name = sc.nextLine();

        System.out.print("새 나이: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("새 학번: ");
        String newStudentNumber = sc.nextLine();

        StudentRequestDto dto = new StudentRequestDto(name, age, newStudentNumber);

        boolean result = controller.updateStudent(dto);

        System.out.println(result ? "수정완료": "해당 학번의 학생을 찾을 수 없습니다." + studentNumber);

    }

    private void deleteStudentView() {
        System.out.print("삭제할 학생의 학번: ");
        String studentNumber = sc.nextLine();

        boolean result = controller.removeStudent(studentNumber);

        System.out.println(result ? "삭제 완료!" : "해당 학생을 못찾겠어요 " + studentNumber);

    }
}
