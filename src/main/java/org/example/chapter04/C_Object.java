package org.example.chapter04;

//클래스 구조
/*
    1. 필드(Filed): 데이터를 표현하는 속성
    2. 메서드 (Method): 데이터의 동작
    3. 생성자(Constructor): 데이터를 생성하는 역할을 함
 */

class Car {
    //클래스의 속성(필드값) 만들기
    String model; //모델명
    int year; //제조년도

    // 클래스의 행동(method)
    // => 클래스 내부에서 정의된 함수, 객체의 행동을 표현함
    // - 클래스의 속성을 사용해 특정 작업을 수행 || 해당 값을 변경, 반환 가능
    // 무조건 필드값을 사용해야만 한다는건 아님
    /*
        메소드 구조
        반환타입 메서드명(매개변수..) {
            메서드의 동작을 정의
            - 반환타입엔 기본타입 다 들어감
        }
     */

    void displayInfo() { //lowerCamelCase 사용해 선언
        // void?
        // => 해당 메서드(함수, 행동)의 의 반환하는 결과가 없음
        // >> 반환(return)이 존재하지 않을 경우 메서드명 앞에 반드시 작성 필요

        System.out.println("Model" + model + ",Year" + year);
    }

    //클래스의 생성자
    // => 클래스의 이름과 동일한 메서드(생성자는 메서드의 일부), UpperCamelCse 사용
    // - 객체가 생성될 때 자동으로 호출, 클래스 내부의 필드를 초기화하는 경우 주로 사용함
    // 메서드와의 차이점? 반환타입을 가지지 않음.

    Car (String modelName, int year) {
        // 필드명: model, year
        // 생성자의 매개변수: modelName, year
        //매개변수는 필드명과 달라도 괜찮음. => 우리는 클린코드를 지향.
        model = modelName;
        this.year = year;
        //this => 클래스 그 자체의 객체를 가리킴, 객체 자신을 참조하는 데 사용됨.
        // => 클래스의 필드와 생성자에서 변수명이 같을 경우 구분을 위해 사용.
        //Car.year이라 해도 같은뜻?
    }
}

public class C_Object {
    public static void main(String[] args) {
        // == 객체 생성 (객체 인스턴스화) == //
        // new 연산자 사용.
        // => 클래스의 생성자를 호출 -> 객체의 초기 필드 상태를 설정
        // -> 생성된 객체의 메모리 주소를 반환해 참조 변수에 저장

        // 클래스타입 변수명 = new 생성자호출(필요한 데이터....);
        Car myCar = new Car("volvo xc60", 2025);
        System.out.println(myCar);

        // == 객체 사용 == //
        // .연산자 사용 -> 객체 내부의 필드와 메서드를 사용

        // 1. 필드 접근
        // : 객체명.필드명;
        // A.B => A객체 안에 B라는 값을 주세용

        System.out.println(myCar.model);
        System.out.println(myCar.year);

        // 2. 메서드 호출
        // : 객체명.메서드명();
        // A.B() A안의 B를 실행해주세용

        myCar.displayInfo();

        //객체 생성 구문
        // '클래스명' 객체명 = new 클래스명(생성자 매개변수값 전달);
        // >> 좌항의 클래스명 => 지정된 클래스를 기반으로 생성된 객체임을 나타냄
        // >> 우항의 클래스명 => 생성자 호출(메서드 호출과 형식이 같음)

    }
}
