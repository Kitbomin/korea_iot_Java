package org.example.book_managemnet_system.service;

import org.example.book_managemnet_system.model.Book;

import java.util.ArrayList;
import java.util.List;

interface BookService {
    void addBook(Book book);

    public void updateBookAuthor(int id, String author);
    public void deleteBook(int id);


    List<Book> searchID(int id);

    List<Book> searchTitle(String title);

    ArrayList<Book> searchAll(List<Book> books);
}
