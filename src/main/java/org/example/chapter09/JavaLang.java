package org.example.chapter09;

// == java.lang 패키지 ==
// : 자바 프로그램의 가장 기본적인 클래스들을 포함
//   - 별도의 import 없이 사용 가능함

// 1) Object 클래스
//  : 자바의 모든 클래스의 최상위 클래스
//  - 모든 클래스가 Object 클래스를 상속받음

// 2) Math 클래스
//  : 수학연산 및 함수를 제공하는 클래스
//  - 모든 필드와 메서드가 static임 (Math.메서드명() 호출)

// 3) String 클래스
//  : 문자열 조작을 위한 다양한 메서드 제공

class MyClass extends Object{
    private int id;
    private String name;

    MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        // 객체의 문자열 표현을 반환
        // - 기본 구현(super)에서는 '객체 클래스명' + @ + 메모리 주소 반환
        // - 오버라이딩한다면 원하는 정보를 반환할 수 있음
        return "MyClass[ID: " + id + " / NAME: " + name + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        // 현재 this와 매개변수의 Object가 동등한지 비교
        // - 두 객체의 참조를 비교(주소값 비교)
        return super.equals(obj);
    }

    String displayInfo() {
        return "MyClass[ID: " + id + " / NAME: " + name + " ]";
    }
}

public class JavaLang {
    public static void main(String[] args) {
        System.out.println("==Obj==");
        MyClass myClass1 = new MyClass(1, "sksk");
        System.out.println(myClass1);
        System.out.println(myClass1.toString());
        System.out.println(myClass1.displayInfo());

        MyClass myClass2 = new MyClass(2, "dfas");

        //equals() 메서드 : 인스턴스 메서드

        System.out.println("myClass1과 myClass2의 비교: " + myClass1.equals(myClass2));

        MyClass myClass3 = myClass1;
        System.out.println("myClass1과 myClass3의 비교: " + myClass1.equals(myClass3));

        String s1 = "이승아";
        String s2 = "이승아";

        System.out.println(s1.equals(s2));
        //문자열의 경우 equals 메서드가 두 문자열의 내용(값)을 비교함

        System.out.println(" == Math == "); // Math 클래스 내부의 모든 필드와 메서드는 static 이다.

        System.out.println(Math.abs(-10)); //absolute value: 절대값을 반환함

        System.out.println(Math.max(10, 20)); //두가지 중 최대값
        System.out.println(Math.min(10, 20)); //두가지 중 최소값

        System.out.println(Math.sqrt(16)); //제곱근 반환함

        System.out.println(Math.pow(2,3)); //pow(a,b) a의 b 제곱을 나타냄

        System.out.println(Math.random()); //무작위 난수 생성, 0.0 이상, 0.1 미만의 난수를 생성함

        System.out.println(" == String == ");
        
        String message = "Merry X-mas";
        System.out.println(message.length()); //문자열의 길이 반환 // 문자 뿐만 아닌 공백, 기호까지 포함시킴

        boolean isEquals = message.equals("Merry Christmas");
        System.out.println(isEquals);

        //substring(int start, int end);
        // 시작 인덱스(포함) 부터 끝 인덱스(미포함) 미만 까지의 부분 문자열을 반환함
        // 문자열 인덱스 0~ 공백과 기호도 인덱스 번호를 가짐

        System.out.println(message.substring(6, 10));

        System.out.println(message); //문자열 기능을 활용해도 기본 데이터 변환이 일어나진 않음 >> 문자열의 불변성

        // indexOf(String str)
        // - 문자열에서 특정 문자열의 첫번째 위치를 반환
        int index = message.indexOf("X-mas");
        System.out.println(index);

        // CharAt(int index)
        // - 특정 인덱스의 문자를 반환
        char c = message.charAt(6);
        System.out.println(c);


    }
}
