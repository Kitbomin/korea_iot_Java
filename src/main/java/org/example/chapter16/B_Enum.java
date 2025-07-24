package org.example.chapter16;

import lombok.ToString;

/**
 * === Enum (열거형) 자료형 ===
 * : 서로 관련된 '상수' 들의 집합을 표현하는 데 사용
 * - 서로 유기적인 관계성을 가짐
 * - 자바의 클래스로 취급이 됨
 * - 의미 있는 값들과 로직을 함께 담을 수 있는 구조로 활용됨(가독성, 유지보수성 향상)
 *
 * Enum 선언 방식
 * - enum 키워드 사용
 *   enum enum명 {}
 *   >> 명명 규칙과 형식이 클래스와 동일함
 *   >> 중괄호 내에서 열거할 데이터를 ,로 구분해 나열함
 */

enum Fruits {
    // ENUM의 요소들은 상수지만 final 키워드가 생략된 상수들이다.
    // : UPPER_SNAKE_CASE 사용해야함
    //유기적인 관계를 가지는 과일들
    APPLE, BANANA, ORANGE
}


@ToString
class FruitsClass {
    String name; //과일의 이름

    FruitsClass(String name) {
        this.name = name;
    }
}

enum CoffeeSize {
    SMALL(100), MEDIUM(200), LARGE(300); //각 필드는 CoffeeSize(Enum)과 대등함
    // >> 이 위의 값들은 곧 생성자 호출이라 볼 수도 있음

    private final int ml;

    CoffeeSize(int ml) {
        this.ml = ml;
    }

    public int getMl() {
        return ml;
    }
}




public class B_Enum {
    public static void main(String[] args) {
        // 상수 키워드는 클래스의 static final 필드처럼 쓰임
        // : Enum명.데이터;
        // >> 각 상수는 정의된 Enum 타입으로 간주됨. -> Fruits가 타입이 됨
        Fruits apple = Fruits.APPLE;
        System.out.println(apple);


        //Fruits 클래스 인스턴스화
        FruitsClass fruit = new FruitsClass("이승아");
        System.out.println(fruit); //FruitsClass(name=이승아) <- 이런 과일은 존재하지 않음

        // == ENUM의 주요 메서드 == //

        // 1) values(): 열거형의 모든 값을 배열로 반환함
        System.out.println(Fruits.values()); // 배열의 주소값이 출력됨

        // 값으로 출력하고 싶으면 이렇게
        for (Fruits fruitValue: Fruits.values()) {
            System.out.println(fruitValue);
        }

        System.out.println();

        // 2) name(): ENUM의 상수를 문자열로 반환해줌
        String appleName = Fruits.APPLE.name();
        System.out.println(appleName);


        // 3) valueOf(String name): 문자열을 Enum 상수로 반환해줌
        // : 잘못된 문자열 전달 시 IllegalArgumentException 발생
        Fruits orange1 = Fruits.valueOf("ORANGE");
//        Fruits orange2 = Fruits.valueOf("Orange"); IllegalArgumentException: No enum constant org.example.chapter16.Fruits.Orange => 대소문자까지 확인함


        // 4) ordinal(): ENUM 상수의 순서를 반환 (0부터 시작함 -> 인덱스 번호처럼)
        System.out.println(orange1.ordinal());


        // == CoffeeSize == //
        CoffeeSize size = CoffeeSize.MEDIUM;
        System.out.println(size + "'s ml: " + size.getMl() + "ml");

        CoffeeSize anotherSize = CoffeeSize.LARGE;
        System.out.println(anotherSize + "'s ml: " + anotherSize.getMl() + "ml");


    }
}
