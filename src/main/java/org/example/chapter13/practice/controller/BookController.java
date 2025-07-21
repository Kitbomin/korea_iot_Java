package org.example.chapter13.practice.controller;

//사용자의 요청 처리

import org.example.chapter13.practice.View.BookView;
import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.service.BookServiceImpl;

import java.util.List;

public class BookController {
    //싱글톤 패턴 인스턴스화(BookServiceImpl)
    private final BookServiceImpl service = BookServiceImpl.getInstance();

    //뷰 인스턴스화
    private final BookView view = new BookView();

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getInputMenuNumber();

            switch (choice){
                case 1: //책을 추가 : 요청 데이터 O, 반환 데이터 X
                    Book book = view.getBookDetails();

                    if (book != null) service.addBook(book);
                    else System.out.println("필수 데이터 값을 다시 확인해주세요");

                    break;

                case 2: //책 단건 조회: 요청데이터 O, 반환 데이터 O
                    String findBookId = view.getInputString("ID");
                    if (findBookId != null){
                        Book foundBook = service.findBookById(findBookId);
                        view.displayBook(foundBook); //반환데이터
                    }
                    break;


                case 3: //책 전체 조회: 요청 데이터 X, 반환 데이터 O
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;

                case 4: //도서 수정
                    String updateId = view.getInputString("ID");
                    if (updateId != null) {
                        Book updatedBook = view.getBookDetails();

                        if (updatedBook != null) {
                            service.updateBook(updateId, updatedBook);
                        }
                        else {
                            System.out.println("수정할 도서 정보가 유효하지 않습니다.");
                        }
                    }

                    break;

                case 5: //도서 삭제
                    String removeId = view.getInputString("ID");

                    if (removeId != null) {
                        service.deleteBook(removeId);
                    }

                    break;

                case 0:
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못된 입력이에요. 메뉴 번호를 다시 입력해주세요");


            }

        }
    }

}
