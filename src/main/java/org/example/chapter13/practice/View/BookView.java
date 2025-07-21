package org.example.chapter13.practice.View;

//사용자의 요청을 받고, 응답을 제공

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.model.Fiction;
import org.example.chapter13.practice.model.NonFiction;

import java.util.List;
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
            sc.nextLine();

        }catch (Exception e){
            System.out.println("잘못된 입력입니다. 숫자를 입력하셔요");
            sc.nextLine();
            return -1;
        }

        return choice;
    }


    // 문자열 데이터 입력 받는 space
    public String getInputString(String data) {
        System.out.println("도서" + data + "을(를) 입력하세요");
//        sc.nextLine(); // => 버퍼처리(메뉴 입력 후 남아있는 버퍼 처리)
        String value = sc.nextLine().trim(); //trim => 문자열 양쪽의 공백을 제거

        if (value.isEmpty()) {
            //문자열 내용 값이 없는 경우 => 빈 문자열인 경우
            System.out.println(data + " 값은 필수입니다. (비워둘 수 없습니다.");
            return null;
        }
        return value;
    }


    // 책 상세 정보 입력
    //Book 이라는 상위 타입을 받고있음
    public Book getBookDetails() {
        sc.nextLine();

        String id = getInputString("ID");
        if (id == null) {return null;}

        String title = getInputString("TITLE");
        if (title == null) {return null;}

        String author = getInputString("AUTHOR");
        if (author == null) {return null;}

        //책 종류가 두가지임
        System.out.println("1. Fiction / 2. NonFiction");
        int type = getInputMenuNumber(); //숫자값을 입력하지 않으면 -1 값을 반환
        if (type == -1) return null;

        if (type == 1) {
            //Fiction
            String genre = getInputString("장르");
            if (genre == null) {return null;}

            return new Fiction(id, title, author, genre);

        }else if (type == 2){
            //NonFiction
            String field = getInputString("분야");
            if (field == null) {return null;}

            return new NonFiction(id, title, author, field);

        }else {
            System.out.println("잘못된 선택입니다. 1 또는 2를 선택하세용");
            return null;
        }
    }

    //단건조회
    public void displayBooks(List<Book> books){
        if (books.isEmpty()){
            //배열에 요소가 없는 경우
            System.out.println("등록된 도서 없음");
        }
        else {
            for (Book book: books) {
                System.out.println(book);
            }
        }
    }

    //전체조회
    public void displayBook(Book book) {
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없어요");
        }
        else {
            System.out.println(book);
        }
    }

}
