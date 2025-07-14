package org.example.chapter12.controller;

import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;



public class BookController {
    // 실제 데이터들이 저장되는 리스트
    private List<Book> books;
//    private final List<Book> books = new ArrayList<>(); -> 필드 주입 형식
    // >> 코드 간결화, 초기값 확인에 용이

    //생성자 주입형식
    // >>> 유연성 증가: 생성자를 통해 다른 리스트로 주입이 가능함(테스트용 더미 리스트 ...)
    // >>> 의존성 주입 구조로 변경도 가능함
    // >>> 하지만 코드 복잡성이 증가함

    public BookController(List<Book> books) {
        this.books = books;
    }


    //1. 책 추가(요청값: 책 데이터, 응답: 없음)
    public void addBook(String title, String author, String publisher) {
        Book newBook = new Book(title, author, publisher);
        books.add(newBook);
    }

    //2. 전체 책 조회(요청값: 없음, 응답: 책 데이터 리스트 반환)
    public List<Book> getAllBooks() {
        return books;
    }


    //3. 책 검색( 책 조회 ) (요청값: 검색어, 응답: 검색된 책 데이터 리스트)
    public List<Book> searchBook(String title) {
        List<Book> result = new ArrayList<>();

        for (Book book: books) {
            if(book.getTitle().contains(title)) {
                //문자열A.contains(문자열 B) => A에 B가 포함되었는지의 유무를 boolean으로 반환
                result.add(book);

            }
        }

        return result;
    }

}
