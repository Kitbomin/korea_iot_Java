package org.example.chapter13.practice.controller;

//사용자의 요청 처리

import org.example.chapter13.practice.View.BookView;
import org.example.chapter13.practice.service.BookServiceImpl;

public class BookController {
    //싱글톤 패턴 인스턴스화(BookServiceImpl)
    private final BookServiceImpl service = BookServiceImpl.getInstance();

    //뷰 인스턴스화
    private final BookView view = new BookView();

    public void start() {
        while (true) {

        }
    }

}
