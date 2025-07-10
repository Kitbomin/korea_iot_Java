package org.example.chapter05;

// === 인자와 매개변수와의 관계 === //
//1. 인자(argument)
//2. 매개변수 (parameter)

//사칙연산 클래스
//: 두개의 값을 매개변수로 받아 사칙연산 수행

class MyMath {
    int add (int a, int b) { //
        return a+b;
    }

    int subtract (int a, int b) {
        return a - b;
    }

    int multiply (int a, int b) {
        return a * b;
    }

    int divide (int a, int b) {
        // 메서드 내부에서 return 키워드를 만날 시 -> 메서드 종료가 일어남
        // 메서드 안에서도 조건에 따라 반환값을 달리할 수 있음
        //      => 중요한건 반환타입은 일치하거나 자동 형 변환이 가능할 것
        if (b == 0) {
            System.out.println("정수 0으로 나눌 수 없습니다.");
            return b;
        } else {
            return a/b;
        }

    }

    double doubleDivided(int a, double b) {
        return a / b;
    }

    void noReturn() {
        System.out.println("해당 메소드는 반환값이 없습니다.");

        return; // 자바 컴파일러가 반환타입의 void를 읽는 경우 해당 메서드의 마지막에 return; 을 자동 추가하게 됨
    }
    // 조건부 반환형식
    int max (int a, int b) {
        //정수 a, b를 비교해 더 큰 값을 반환

        if (a > b) return a;
        else return b;

    }
    int min (int a, int b) {
//        int result;
//        if (a < b) result = a;
//        else result = b;
//
//        return result;

        //삼항연산자
        return a > b ? b : a;


    }
}


public class C_Method {
    public static void main(String[] args) {
           //객체화
        // 좌항 -> 클래스 타입 객체명 = new 연산자 사용 -> 클래스의 생성자가 호출
        // - 클래스 생성자는 반드시 한 개 이상 존재!
        // - 사용자 정의 생성자가 없는 경우 빈 생성자(인자,반환)둘 다 없는걸 생략
        MyMath myMath = new MyMath();

        System.out.println(myMath.add(10,20));
        System.out.println(myMath.subtract(10,20));
        System.out.println(myMath.multiply(10,20));
        System.out.println(myMath.divide(10,20)); //자기 자신보다 큰 수로 나누면 '0' 반환

        System.out.println(myMath.divide(10,0));

        System.out.println(myMath.doubleDivided(10,0.0)); // 인피니티? -> 무제한의 수



        // 인자값과 매개변수의 관계
        // : 자바는 값에 의한 호출 방식을 사용 -> 메서드 호출 시 인자값이 매개변수에 복사되어 전달됨
        // 인자는 실질적인 데이터 / 매개변수는 해당 데이터를 메서드 블럭 내에서 저장할 임시 변수 -> 메서드 시행 시에만 유효


    }
}
