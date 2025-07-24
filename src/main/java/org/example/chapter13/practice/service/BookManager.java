package org.example.chapter13.practice.service;

import java.util.List;

/**
 * 도서 관리 시스템의 비즈니스 로직을 인터페이스화
 * : CRUD 기능 처리
 * - 제네릭 타입을 통한 책의 타입 정의
 */

public interface BookManager<T> {
    //T(타입변수) : 해당 인터페이스로 실질적인 비즈니스 로직구현 시 타입을 명시
    void addBook(T book);

    //단건 조회
    T findBookById(String id); //id로 단건조회

    List<T> listAllBooks(); //전체조회

    void updateBook(String id, T updatedBook);

    void deleteBook(String id);

}
