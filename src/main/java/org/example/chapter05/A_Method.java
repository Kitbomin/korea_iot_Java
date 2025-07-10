package org.example.chapter05;
//자바의 객체지향프로그래밍
// '클래스' = 객체 생성 템플릿(설계도)
//  -> 필드, 메서드, 생성자가 들어있다.

// 필드: 클래스의 특성이 담긴 속성기능

// == 메서드 == //
/*
    형태
    반환타입 메서드명(매개변수 n개) {
        - 메서드의 기능과 동작 정의
    }

    1. 반환타입(유형): 메서드 동작 후 반환되는 데이터 유형을 지정
    - 반환 데이터가 없는 경우 void 지정

    2. 메서드명: lowerCamelCase 사용, 동사 사용을 권장
    -- 변수명은 명사 사용을 권장(배열명은 복수 명사 사용 권장)
    ex) eat(먹다) - 메서드 || eating(먹기) - 변수

    3. 매개변수(parameter) 목록: 메서드에 전달되는 입력값들의 목록
    - 0개 이상 지정 (지정하지 않을 수도 있음)
    - 각 매개변수는 변수의 선언과 같이 자료형과 함께 선언됨
    *주의점* 일반 변수 선언에서 쓰이는 동일한 데이터 타입의 생략이 불가능
            >>> int a,b; => 매개변수에서는 이렇게 선언 안됨

 */

class Calculater {
    int a,b;
    int add (int a, int b){
        //return: 메서드의 반환을 담당, 반환타입과 일치하는 데이터를 동반해야함
        //void 타입이면 생략 가능[또는 return;]
        return a + b; // 더하기 기능
    }

    void nothing () {
        return;
    }

}

public class A_Method {
    public static void main(String[] args) {
        //메서드 사용
        //객체명.메서드(); -> 인스턴스화

        Calculater calc = new Calculater(); // 객체 생성
        System.out.println(calc.add(3,5));

        //메서드의 반환값이 있는 경우: 변수에 할당받아 사용이 가능함
        int result = calc.add(123,456); // => 이렇게도 사용 ㄱㄴ 유사 파이썬...?
        System.out.println(result);
    }
}
