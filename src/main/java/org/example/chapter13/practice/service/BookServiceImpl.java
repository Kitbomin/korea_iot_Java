package org.example.chapter13.practice.service;

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.repository.BookRepository;

import java.util.List;

//비즈니스 로직 처리 - 싱글톤 패턴 적용

public class BookServiceImpl implements BookManager<Book>{
    //싱글톤 패턴 구현 식
    private static BookServiceImpl instance;

    private final BookRepository repository = BookRepository.getInstance();

    private BookServiceImpl() {}


    public static BookServiceImpl getInstance(){
        if (instance == null) {
            instance = new BookServiceImpl();
        }
        return instance;
    }

    @Override
    public void addBook(Book book) {
        Book addedBook = repository.save(book); // 저장 완료시 Book 데이터, 저장 실패 시  null값 반환

        if (addedBook == null) {
            System.out.println("해당 ID의 도서가 이미 존재하여 책이 추가 되지 않았습니다.");
        }
        else {
            System.out.println(book.getTitle() + " (이)가 추가되었습니다.");
        }
    }

    @Override
    public Book findBookById(String id) {
        Book book = repository.findById(id);

        if (book == null) {
            System.out.println("ID [ " + id + " ]에 해당하는 도서를 찾을 수 없습니다.");
        }

        return book;
    }

    @Override
    public List<Book> listAllBooks() {
        return repository.findAll();
    }

    @Override
    public void updateBook(String id, Book updatedBook) {
        //저장소에는 수정을 위한 메서드가 정의되어있지 않음
        // 수정: id와 일치하는 기존의 데이터 삭제 + 신규(수정된) 데이터 저장 형식으로 구현

        Book existingBook = repository.findById(id);

        if (existingBook == null) {
            //수정할 책이 존재하지 않는 경우
            System.out.println("ID [ " + id + " ]에 해당하는 도서를 찾을 수 없습니다.");
            return;
        }

        //수정할 책이 존재하는 경우
        repository.delete(id);

        addBook(updatedBook);

    }

    @Override
    public void deleteBook(String id) {
        Book existingBook = repository.findById(id);

        if (existingBook == null) {
            //삭제할 책이 존재하지 않는 경우
            System.out.println("ID [ " + id + " ]에 해당하는 도서를 찾을 수 없습니다.");
            return;
        }

        repository.delete(id);

        System.out.println(existingBook.getTitle() + " 이(가) 삭제되었습니다.");

    }
}
