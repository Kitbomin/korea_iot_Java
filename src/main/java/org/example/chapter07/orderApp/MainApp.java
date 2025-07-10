package org.example.chapter07.orderApp;

/*
    MainApp 클래스
    : 주문 시스템의 실행 진입점
    - 제품 생성, 주문 생성, 주문 결과를 출력하게 됨
 */

public class MainApp {
    public static void main(String[] args) {
        Product laptop = new Electronics("laptop", 5000);
        Product apple = new Food("apple", 600);

        //주문 생성
        Order order1 = new Order(laptop, 1);
        Order order2 = new Order(apple, 10);



        //주문 결과
        System.out.println(order1);

        Food onlyapple = (Food) apple;
        onlyapple.text();

        System.out.println(order2);





    }
}
