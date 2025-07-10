package org.example.chapter05;

// === 메서드의 종류 === //
// - 인스턴스 메서드, 정적 메서드

// '클래스' 필드의 종류
//  : (인스턴스) 필드, 정적(클래스, static) 필드 -> 주민번호 같은 경우는정적이 아님.

// 클래스 메서드
// - 인스턴스 메서드
//          : 객체(인스턴스)를 생성 한 후 호출할 수 있는 메서드
//          : 고유한 행위를 정의
// - 정적 메서드
//          : 객체 생성 없이 호출 가능한 메서드
//          : 공통적인 행위 또는 인스턴스 필드에 의존하지 않는 행위를 정의함.

// 1. 정적 메서드?
//    : static 키워드를 사용해 정의된 메서드. 클래스 명으로 직접 호출이 가능함.
//    - static 반환타입 메서드명() {}
//    - 클래스명.메서드명();

// 2. 정적 메서드의 특징
//    - 인스턴스 필드(변수)에 의존하지 않는다.
//    -> 인스턴스 필드는 객체화가 필수
//    - 클래스 수준에서 공유되는 데이터를 다룰 대 적합함(클래스 필드)

// 3. 정적메서드 사용 권장 사항
//    - 공통데이터 사용: 정적 필드(모든 인스턴스에 공유)
//    - 독립적인 사용: 필드값과 관계없이 지역변수(매개변수)만으로 작업 처리를 할 수 있어야함.

class Operator {
    //인스턴스 필드이자 변수
    int a, b;

    //인스턴스 메서드
    int add() {
        return a+b;
    }

    int multiply (int a, int b) {
        int result = this.a * b; // => 필드값 * 지역변수임
        // this => 필드값과 지역변수명이 동일하거나, 필드값임을 명시할 때 this 키워드 사용
        return result;
    }

    //정적 메서드
    static int subtract(int a, int b) {
        //int result = a - b; //비 static 필드 'a'은(는) static 컨텍스트에서 참조할 수 없습니다 => 초기화 안해도 쓸 수 있음
        int result = a-b;
        return result;
    }
}

public class D_Method {

    public static void main(String[] args) {

        System.out.println("정적 메서드 사용");
        //클래스명.메서드명();
        //필요한 인자값이 있는 경우 전달해야함

        int result = Operator.subtract(10,3);
        System.out.println(result);

        System.out.println("인스턴스 메서드");
        //객체명.메서드명();

        Operator operator = new Operator();
        operator.a = 10;
        operator.b = 3;

        System.out.println(operator.add());
        System.out.println(operator.multiply(10,20));

    }
}
