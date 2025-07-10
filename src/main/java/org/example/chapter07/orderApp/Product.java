package org.example.chapter07.orderApp;

/*
 * Product 클래스
 *
 * - Field: name(제품명), price(제품가격)
 * - Constructor: Product(name, price)
 * - Method: getName(), getPrice() - getter
 * 			/ calculateTax(): 세금 계산 메서드(기본 10% 세율)
 * */

public class Product {

    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName () {return name;}
    double getPrice () { return price;}

    double calculateTax() {
        return price * 0.1;
    }

}
