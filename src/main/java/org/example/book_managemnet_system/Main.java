package org.example.book_managemnet_system;

import org.example.book_managemnet_system.model.Book;
import org.example.book_managemnet_system.service.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
//
//        //도서 등록
//
//        books.add(new Book(scanner.nextInt(), scanner.nextLine(), scanner.nextLine()));
//
//        //도서 전체 조회
//        bookService.searchAll(books);
//
//        //도서 아이디 ㅈ호ㅚ
//        bookService.searchID(scanner.nextInt());
//        System.out.println(books);
//
//        try {
//            bookService.searchID(scanner.nextInt());
//        }catch (BootstrapMethodError e){
//            System.out.println("조회 실패: " + e.getMessage());
//        }
//
//        //도서 저자 수정
//        try {
//            bookService.updateBookAuthor(1, "김김김");
//        }catch (BootstrapMethodError e){
//            System.out.println("수정 실패: " + e.getMessage());
//        }
//
//        //도서 삭제
//
//        try {
//            Book result = (Book) bookService.searchID(scanner.nextInt());
//            System.out.println(result);
//
//            bookService.deleteBook(scanner.nextInt());
//            System.out.println("삭제 완료");
//        }catch (BootstrapMethodError e) {
//            System.out.println("삭제 실패: " + e.getMessage());
//        }
//
//
//        //도서 제목으로 검색
//        List<Book> searchTitle = bookService.searchTitle(scanner.nextLine());
//        System.out.println("조회된 도서: " + searchTitle);
        while (true) {
            System.out.println(" === 도서관리 === ");
            System.out.println("1. Create 책 추가");
            System.out.println("2. Read 전체 책 조회");
            System.out.println("3. Update 책 수정(저자)");
            System.out.println("4. Delete 책 삭제");
            System.out.println("5. 책 ID 검색");
            System.out.println("6. 책 Title 검색");
            System.out.println("0. 프로그램 종료합니다아");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice){
                    case 1:
                        System.out.println("ID 입력");
                        int id = scanner.nextInt();
                        System.out.println("제목 입력");
                        String title = scanner.nextLine();
                        System.out.println("저자 입력");
                        String author = scanner.nextLine();

                        bookService.addBook(new Book(id, title, author));
                        break;

                    case 2:
                        bookService.searchAll(books);
                        break;

                    case 3:
                        System.out.println("ID로 책의 저자를 수정합니다.");
                        int updateId = scanner.nextInt();
                        System.out.println("저자의 이름은?");
                        String newAuthor = scanner.nextLine();

                        bookService.updateBookAuthor(updateId, newAuthor);
                        break;

                    case 4:
                        System.out.println("삭제할 아이디를 입력하세요");
                        int deleteId = scanner.nextInt();
                        bookService.deleteBook(deleteId);
                        break;

                    case 5:
                        System.out.println("ID로 책을 찾습니다.");
                        int searchId = scanner.nextInt();

                        List<Book> resultId = bookService.searchID(searchId);
                        if (resultId.isEmpty()) {
                            System.out.println("해당 아이디가 없습니다.");
                        } else {
                            for (Book book: books){
//                                resultId.add(book.getId());
                            }
                            System.out.println(resultId);
                        }

                    case 6:
                        System.out.println("제목으로 책을 찾습니다.");
                        String searchTitle = scanner.nextLine();

                        List<Book> resultTitle = bookService.searchTitle(searchTitle);
                        if (resultTitle.isEmpty()) {
                            System.out.println("해당 제목의 책이 없습니다.");
                        }
                        else {
                            for (Book book: books){
//                                resultTitle.add(book.getTitle());
                            }
                            System.out.println(resultTitle);
                        }

                    case 0:
                        System.out.println("종료합니다.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("유효하지 않아요 다시 입력해주세요");
                }

            }catch (BootstrapMethodError e){
                System.out.println(e.getMessage());
            }
        }

    }
}
