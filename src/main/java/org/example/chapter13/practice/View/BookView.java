package org.example.chapter13.practice.View;

//사용자의 요청을 받고, 응답을 제공

import org.example.chapter13.practice.model.Book;

import java.util.Scanner;

public class BookView {
    private final Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("=== 도서 관리 시스템 ===");

        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 단건 조회");
        System.out.println("3. 도서 전체 조회");
        System.out.println("4. 도서 수정");
        System.out.println("5. 도서 삭제");
        System.out.println("0. 종료");
        System.out.println("선택 >>>");
    }

    //사용자 입력값에 대한 데이터 유효성 검증 로직
    public int getInputMenuNumber() {
        int choice;

        try {
            choice = sc.nextInt();


        }catch (Exception e){
            System.out.println("잘못된 입력입니다. 숫자를 입력하셔요");
            sc.nextLine();
            return -1;
        }

        return choice;
    }


    // 책 id 입력 받는 space
    public String getInputId() {
        System.out.println("도서 ID를 입력하세요");
        sc.nextLine(); // => 버퍼처리(메뉴 입력 후 남아있는 버퍼 처리)

        String id = sc.nextLine().trim(); //trim => 문자열 양쪽의 공백을 제거

        if (id.isEmpty()) {
            //문자열 내용 값이 없는 경우 => 빈 문자열인 경우
            System.out.println("ID값은 필수입니다. (비워둘 수 없습니다.");
            return null;
        }
        return id;
    }


    // 책 상세 정보 입력
    public Book getBookDetails() {

    }

}
