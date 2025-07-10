package org.example.chapter01;

public class C_Variable {
    public static void main(String[] args) {
        //===변수===//
        // 데이터를 메모리에 저장하고 사용할 때의 공간

        // 1. 변수선언: 메모리 공간 생성
        // => 데이터 타입 + 변수명;

        String name;
        name = "김보민";

        int price;
        price = 100;

        int num;
        char chr;
        boolean bool;


        // 2. 변수 초기화(할당): 공간에 데이터를 넣는 작업/ 초기화 => 처음 데이터를 넣는 과정 / 할당 => 데이터를 바꾸는 과정
        // => 변수명 = 데이터값;

        num = 10;
        chr = '가'; // char(단일문자)는 '' String(문자열)은 ""
        bool = true;

        // A = B => B의 값이 A에 대입
        // A == B =>  A와 B는 같다


        System.out.println(name);

        // 3. 변수 선언과 동시에 초기화
        // => 데이터타입 변수명 = 데이터값;

        int number = 10;
        char character = '나';
        boolean boolValue = false;

        // === 변수 명명 규칙 === //
        // 문자. 숫자. 기호 사용 가능
        // 1) 대소문자를 구분, 길이의 제한이 없음

        int age;
        int Age;
        //age != Age;

        // 2) 숫자로 변수명을 시작할 수 없음
        // 3) 기호는 _(언더바), $(달러) 만 사용 가능 => 기호로 시작 가능함
        // 4) 자바의 예약어, 키워드는 변수명 사용 x


        // +) 권장사항
        // 변수명은 lowerCamelCase 사용 권장 => 소문자로 시작하되 연결하는 단어의 시작은 대문자로 작성

        int strawberryChochoCake;

        // UpperCamelCase
        int StrawberryChocoCake;

        // lower_snake_case
        int strawberry_choco_cake;

        // === 변수의 재할당 === //
        int height = 170;

        // 변수의 재할당: 변수명 = 변경할 값;
        height = 168;

        System.out.println(height);

        // === 상수(contant) === //
        // 프로그램 실행 동안 그 값이 변하지 않는 변수
        // => 선언과 동시에 반드시 초기화가 이루어져야함.

        //1. 상수 선언 방법
        // final 데이터타입 변수명 = 데이터값;

        //2. 상수 명명 규칙
        // Upper_Snake_Case
        // 모든 문자는 대문자, 연결은 _ 사용
        final int RESIDENT_NUMBER = 1234567; // 주민번호
        //RESIDENT_NUMBER = 999999; => 재할당 안됨


        // === 변수, 상수 명을 활용한 데이터 값 호출 === //
        int numberValue = 10;
        System.out.println(numberValue);


    }
}
