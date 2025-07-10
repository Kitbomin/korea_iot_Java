package org.example.chapter04;

// == 객체 지향 프로그램의 변수 == //

// == 필드와 지역 변수의 구분 == //

//    1. 필드 (속성)
//    : 객체의 지속적인 상태를 저장하는 '클래스 내부'의 변수.
//        - 메서드와 분리되어 클래스의 최상단에 위치한다.
//        - 명시적으로 초기화하지 않으면 기본값으로 초기화됨

//        - 인스턴스필드, 클래스필드

//class A {
//    해당 위치의 변수 >> 필드
//}
//    1) 인스턴스 필드(변수)
//    : 클래스의 각 객체(인스턴스)에 속한 변수
//      >> 클래스 내부에서 선언, '객체가 생성될 때' 메모리에 할당이 됨
//      >> 각 인스턴스마다 다른 값을 가질 수 있음.(겹칠 수도 있다.)

//    2) 클래스(staic, 정적) 필드(변수)
//    : 클래스의 '모든 인스턴스에서 공유되는' 데이터변수임
//      >> 'static' 키워드를 사용해 선언되는 변수를 클래스 변수라 함.
//      >> 해당 클래스로 생성되는 인스턴스가 모두 클래스에서 선언한 동일한 값을 가져야함.
//      => 프로그램이 시작될 때 생성 ~ 프로그램이 종료될 때 소멸함.
//          >>> JVM의 Method Area 영역에 올라감.
//
//    2. 지역변수
//    : 특정 기능(메서드)가 실행되는 동안에만 존재하는 '일시적인 변수'
//        - 메서드(생성자 포함) 또는 블럭{} 내부 에서 선언이 됨.
//        - 필드와의 차이점 => 자동으로 초기화되지 않음. 반드시 초기화 후 사용필요.
//          >> 초기화 없이 사용할 경우 예외가 발생

//변수명 => 동일한 스코프 내에서 같은 변수명 사용 x

//class CarClass{} 클래스 명 - 접근 제한자에 따라 같은 이름으 ㅣ클래스 사용 x

//class Car{} 접근 제한자의 생략 -> 기본값 default 설정이 됨 (같은 패키지 안에서 사용 가능)

class CarClass {
    //메서드는 동일한 스코프 내에서 같은 변수명 사용이 가능(제약조건은 있음)

    //1. 필드(속성)
    // 1) 인스턴스 필드: 각 객체마다 다른값을 가짐
    String brand;
    String color;
    int speed;

    // 2) 클래스(정적, static) 필드: 클래스의 모든 객체가 동일한 값을 가짐
    static int tireNumber;
    static int doorNumber;

    //2. 지역변수
    void accelerate(int increment) {
        //speed 필드: 지역변수 내에서도 접근가능
        //increment 필드: 메서드 내에서만 유효하다

        speed += increment;
    }

}

public class E_Field {
    public static void main(String[] args) {
        // 1) 인스턴스 필드 사용방법
        // 객체명.필드명
        // 2) 클래스 필드 사용방법
        // 클래스명.필드명; || 객체명.필드명; (이거 쓰면 인스턴스필드랑 햇갈림)
        // >> 각 객체명으로도 호출 가능하지만, 클래스명 호출 방법을 권장함

        System.out.println(CarClass.doorNumber);
        System.out.println(CarClass.tireNumber);

        //클래스 필드값 변경

        CarClass car1 = new CarClass();
        CarClass car2 = new CarClass();

        //▼ 예외, 오류발생은 하지 않지만 권장 x
//        car1.doorNumber = 3; //이게 carClass 자체의 도어넘버까지 영향을 줌
//        System.out.println(car2.doorNumber);
//        System.out.println(CarClass.doorNumber);

        //인스턴스 필드 사용
        car1.brand = "kia";
        car1.color = "black";

        car1.accelerate(100);
        car1.accelerate(100);
        System.out.println(car1.speed);

        //System.out.println(CarClass.brand); -> 인스턴스 필드는 클래스로 호출 불가능함



    }
}
