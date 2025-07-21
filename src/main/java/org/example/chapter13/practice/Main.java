package org.example.chapter13.practice;

/*
 * MVC 패턴 사용 도서관리 시스템
 *
 * @Model (프로젝트 데이터 정의)
 * : 도메인 객체 정의, 실제 비즈니스에서 다루는 데이터와 상태를 표현
 *
 * - Book 클래스 (부모)
 *   - Fiction, NonFiction 클래스 (자식)
 *
 *
 * @View (뷰 계층)
 * : 사용자에게 정보를 출력하고 입력 받는 역할(프론트엔드)
 * - 콘솔 기반으로 sout. Scanner 사용해 입력처리
 * - 비즈니스 로직을 포함하지 않음 -> 사용자의 입출력만 처리
 * - 행위동작 들어가면 안됨
 *
 *
 * @Controller(컨트롤러 계층)
 * : View와 Service 사이를 연결하는 역할
 * - 사용자의 입력을 받고, 적절한 비즈니스 로직을 호출해 처리
 * - 결과(응답)를 다시 View에 전달
 *
 *
 * @Service
 * : 비즈니스 로직을 구현하는 계층
 * - 실제 데이터 처리를 담당
 *
 *
 * @Repository
 * : 데이터를 저장, 조회, 삭제 등의 역할을 담당
 * - DB와 연결(Service 에만 연결되어 외부에서 직접 접근할 수 없도록 구현)
 *
 * [사용자] -> View -> Controller -> Service -> Repository -> [데이터] -> Repository -> Service -> Controller -> View -> [사용자]
 * */


import org.example.chapter13.practice.controller.BookController;

public class Main {
    public static void main(String[] args) {
        BookController controller = new BookController();
        controller.start();
    }
}
