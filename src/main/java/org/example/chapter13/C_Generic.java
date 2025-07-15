package org.example.chapter13;

import java.util.ArrayList;
import java.util.List;

/**
 * 1) 제네릭 사용 목적
 * : 여러 타입을 하나의 코드로 처리해 중복을 줄이고 타입 안정성을 확보하는 것
 *
 * 2) 와일드 카드 ? 사용 시점
 * : 타입을 알 수 없거나 타입에 관계 없이 처리할 때 사용
 *
 * 3) extends VS super 차이점
 * : extends(상속받는 타입만 허용 -> 읽기전용)(상한제한)
 * : super(조상 타입만 허용 -> 쓰기 가능)(하한제한)
 *
 * 4) list.add(값)이 되지 않는 이유
 * : 와일드 카드는 타입이 불확실해서 안정성 문제로 컴파일이 값의 할당을 막음 -> 뭔 줄 알고 추가를 하지? 같은 상황
 *
 */

// == 주문 관리 시스템 == //
// 상품(Product)과 할인(Discount) 정보를 관리
    // : 할인 정책 사용 시 Product 또는 Product를 상속받는 하위 클래스(Electronics, Furniture)에서만 적용

// 1. 상위 클래스 정의
class Product {
    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
        // 지역변수 초기화가 안됨
    }

    public String getName() {return name;}
    public int getPrice() {return price;}

}

// 2. 하위 클래스(Electronics, Furniture)

//2-1 Electronics
class Electronics extends Product {
    public Electronics(String name, int price) {
        super(name,price);
    }
}

//2-2 Furniture
class Furniture extends Product {
    public Furniture(String name, int price) {
        super(name, price);
    }
}


// 3. 할인 정책 클래스
class DiscountPolicy {
    public static double applyDiscount(
                // 매개변수 집중
                List<? extends Product> products
                // => 리스트 컬렉션 프레임워크 형식에 Product 타입을 가지거나, 해당 타입의 하위클래스(전자, 가구) 만을 허용
                // 상한 한정
                , double discountRate) {

        double totalDiscount = 0.0;
        for (Product product: products) {
            //상위 클래스는 읽어오는 것 밖에 못함
            double discount = product.getPrice() * discountRate;
            totalDiscount += discount;
            System.out.println(product.getName() + " 할인 적용: " + discount + " 원");
        }
        return totalDiscount;
    }
}

public class C_Generic {
    public static void main(String[] args) {

        List<Electronics> electronics = new ArrayList<>();

        electronics.add(new Electronics("냉장고", 108));
        electronics.add(new Electronics("세탁기", 130));
        electronics.add(new Electronics("인덕션", 80));

        double totalElectronics = DiscountPolicy.applyDiscount(electronics, 0.1);
        System.out.println("총 가전 할인 액: " + totalElectronics);


        List<Furniture> furniture = new ArrayList<>();

        furniture.add(new Furniture("침대", 230));
        furniture.add(new Furniture("쇼파", 170));
        furniture.add(new Furniture("화장대", 50));

        double totalFurniture = DiscountPolicy.applyDiscount(furniture, 0.2);
        System.out.println("총 가구 할인액: " + totalFurniture + " 원");

    }
}
