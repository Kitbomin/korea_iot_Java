package org.example.chapter04;


class ClassName {
    //클래스 명은 UpperCamelCase 사용
    //      >>> Car, StudentInfo, BookLibrary...
}

// 2. 객체 Object
// 클래스에 정의된 속성과 메서드를 가지는 실체(instance)
// 클래스를 기반으로 생성 => 클래스의 '인스턴스'라고 불리고 실제 메모리에 할당됨
// >> 각 객체는 독립적인 상태와 행동을 가짐, 서로 다른 객체와의 상호작용이 가능하다.

/*
        객체 == 인스턴스
        인스턴스
        인스턴스화 => 동작을 정의. 클래스라는 템플릿을 기반으로 객체를 만드는 과정.
        > 이 때 만들어진 객체를 인스턴스라고 부름.

 */


public class B_Object {
    public static void main(String[] args) {
        // == class 정의 방법 == //
        /*
            [접근제한자] class 클래스명 {
                클래스가 가지는 속성과 행동 정의
                - 속성(기능): 변수와 비슷함
                - 행동(메서드): 함수를 정의하는 것과 비슷함

             }
         */

        // 접근제한자(접근 제어자)? 생략가능 => 기본적으로 부여되는 값이 있음.
        // => 클래스의 가시성 정의(접근에 대한 권한을 부여하는 역할을 함)
        // => 클래스, 변수, 메서드의 접근 가능 범위를 결정함
        // >> public, private, protected, default(자동지정값)
        // 캡슐화 => 메서드의 접근허가자가 아닌이상 접근 x

        class Car {
            //속성(필드) - 변수선언방식이랑 비슷
            int maxSpeed;
            String color;
            boolean isElectric;
        }

        class Book {
            String title;
            String author;
            int pageNumber;
        }

        class Person {
            String name;
            int age;
            boolean inStudent;
            String[] hobbys; //배열도 넣을 수 있음

        }

        // === 객체 정의 === //
    }
}

// 클래스는 메모리에 업로드? => 올라가지 않음
// 객체는 무엇의 실체? => 클래스의 인스턴스의 실체.
//
