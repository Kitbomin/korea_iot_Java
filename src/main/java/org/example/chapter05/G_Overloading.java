package org.example.chapter05;

// 음식점 클래스 : 다양한 방법으로 음식을 주문받는 메서드
// => 동일한 이름으로 된 메서드로 주문을 받을거임


class Resaourant {
    //메서드 정의: placeOrder()
    //메뉴 이름 (String dish)
    //메뉴 이름 * 수량 제공 (int quantity)
    //메뉴 이름 * 특별 요청사항 (String specialRequest)
    //메뉴 이름 * 수량 제공 * 특별 요청사항

    void plceOrder(String dish) {
        System.out.println(dish);
    }

    void plceOrder(String dish, int quantity) {
        System.out.println(dish + " * " + quantity);
    }

    void plceOrder(String dish, String specialRequest) {
        System.out.println(dish + " - " + specialRequest);
    }

    void plceOrder(String dish, int quantity, String specialRequest) {
        System.out.println(dish + " * " + quantity + " - " + specialRequest);
    }

}


public class G_Overloading {
    public static void main(String[] args) {
        Resaourant restaurant = new Resaourant();

        //자바의 컴파일러가 인자의 형태를 확인하고 자동으로 해당 타입과 순서의 메서드로 인식함

        restaurant.plceOrder("햄버거");
        restaurant.plceOrder("피자", 5);
        restaurant.plceOrder("파스타", "크림을 빼주세요");
        restaurant.plceOrder("햄버거", 2,"호두를 빼주세요");


    }
}
