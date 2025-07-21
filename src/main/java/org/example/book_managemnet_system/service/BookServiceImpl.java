//package org.example.book_managemnet_system.service;
//
//import org.example.book_managemnet_system.exception.BookNotFoundException;
//import org.example.book_managemnet_system.model.Book;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookServiceImpl implements BookService{
//
//    private final List<Book> books = new ArrayList<>();
//
//
//
//    @Override
//    public void addBook(Book book) {
//        books.add(book);
//        System.out.println("추가할 책의 정보를 입력해주세요 \n" +
//                            "제목: " + book.getTitle() +
//                            "저자" + book.getAuthor());
//    }
//
//    @Override
//    public ArrayList<Book> searchAll(List<Book> books) {
//        return new ArrayList<>(books);
//    }
//
//
//    @Override
//    public List<Book> searchID(int id) {
//
//        for (Book book: books) {
//            if (book.getId()){
//                return books;
//            }
//        }
//        return List.of();
//    }
//
//    @Override
//    public List<Book> searchTitle(String title) {
//
//        for (Book book: books) {
//            if (book.getTitle().contains(title)){
//                return books;
//            }
//        }
//        return List.of();
//    }
//
//
//
//    @Override
//    public void updateBookAuthor(int id, String newAuthor) {
//        Book book = (Book) searchID(id);
//        book.setAuthor(newAuthor);
//    }
//
//    @Override
//    public void deleteBook(int id) {
//        Book deleteBook = null;
//
//        for (Book book: books){
//            if (!book.getId()) {
//                continue;
//            }
//            deleteBook = book;
//            break;
//        }
//        if (deleteBook == null){
//            throw new BookNotFoundException("해당 id값이 존재하지 않습니다.");
//        }
//
//        books.remove(deleteBook);
//    }
//}
