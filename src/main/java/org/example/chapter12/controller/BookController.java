package org.example.chapter12.controller;

import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;



public class BookController {
    // 실제 데이터들이 저장되는 리스트
    private List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
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
