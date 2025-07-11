package org.example.chapter10.practice01;

//제품이 가져야 할 필수 구성을 상속 받은 Book 클래스

public class Book extends Item{
    // id, name 이란 필드가 여기에 존재함 -> 상속을 받아와서

    private String isbn;
    private String author;
    private String publisher;
    private int publishYear;
    private int price;
    private int stock;
    private String category;

    //생성자
    public Book (String id, String name, String isbn, String author,String publisher, int publishYear, int price, int stock, String category) {
        super(id, name);
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public String getIsbn () {return isbn;}
    public String getAuthor () {return author;}
    public String getPublisher () {return publisher;}
    public String getCategory () {return category;}
    public int getPublishYear () {return publishYear;}
    public int getPrice () {return price;}
    public int getStock () {return stock;}


    public void updateStock(int quantity) {
        this.stock = quantity;
    }

    @Override
    public void display() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + ", ISBN: " + isbn);
    }
}
