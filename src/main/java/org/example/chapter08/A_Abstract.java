package org.example.chapter08;

// === 추상화 (Abstract) === //
// 1. 추상클래스의 정의
//  : 미완성 클래스(설계도), 일부 구현이 누락된 불완전 클래스
//    >> 자체로 인스턴스를 생성할 수 없음
//    >> 다른 클래스가 상속받아 완성해야만 사용이 가능하다

// 2. 추상클래스의 특징
// 1) 자체로 인스턴스 생성 불가
// 2) 반드시 하나 이상의 추상 메서드를 포함해야함

// ** 하나 이상의 추상 메서드 포함 + 일반 메서드도 포함 가능함 **

// 3. 추상클래스 구현 방법
//  : 클래스 선언 앞에 'abstract' 키워드 사용
//    abstract class AbstractClass명

// 4. 사용 목적
//  : 확장성 제공을 위해 사용
//    - 자식클래스가 공통된 기능을 공유 + 고유 기능을 구현하도록 강제함

// +) 자바는 다중 상속 불가능 => 하나의 extends만 가능함 (여러 부모가 있을 순 없음)

// 5. 추상 메서드
//  : 메서드의 선언부만 존재함, 구현부가 없는 메서드
//    - 자식 클래스에서 해당 메서드를 반드시 구현하도록 강제하는 역할
//    - abstract 키워드 사용 + 구현부 {} 대신 세미콜론을 사용해 선언을 마침

// -- 메서드의 구성: 선언부(시그니처) + 구현부 {} | [접근제어자] 반환타입 메서드명(매개변수...) {구현부 - 메서드의 기능 동작}

// 메서드 오버라이딩 vs 추상 클래스
// - 추상 메서드 : 반드시 자식 클래스에서 오버라이딩해야함 (구현부를 명시하기 위해서)
// - 일반 메서드 : 필요에 따라 오버라이딩 가능

//추상클래스
abstract class Human {
    // 추상 메서드
    abstract void work(); //구현부{} 없이 바로 종료

}

class Police extends Human {//부모의 메서드를 재정의하게끔 강제시킴
    @Override
    void work() { //추상메서드 구현
        System.out.println("경찰은 치안유지 업무를 담당합니다");
    }
}

class Student extends Human {
    @Override
    void work() {
        System.out.println("학생은 공부를 합니다");
    }
}


//다중상속 금지 예시
abstract class Lion {
    abstract void mane();
}

abstract class Tiger {
    abstract void stripe();
}

//class Liger extends Lion extends Tiger { // 이거 안됨... 이게 다중상속이 불가능하다는 뜻 }

// 4. 추상클래스 예시
abstract class Animal {
    abstract void makeSound(); //일반메서드
    void eat() { //일반메서드
        System.out.println("동물은 먹이를 먹어용");
    }
}

class Dog extends Animal {
    //추상메서드는 반드시 재정의하게 됨
    @Override
    void makeSound() {
        System.out.println("멍멍");
    }

    //일반 매서드는 재정의가 선택적임
    @Override
    void eat() {
        System.out.println("강아지는 개껌을 좋아해");
    }
    
    void bark() {
        System.out.println("멍멍왈왈멍멍");
    }
}

class Cat extends Animal{
    @Override
    void makeSound() {
        System.out.println("야옹ㅇ");
    }
    // 일반 메서드 재정의 없이도 작동함
}


abstract class Person extends Animal {
    @Override
    void makeSound() {
        System.out.println("으라챠챠");
    }
}

class Namoo extends Person {
    @Override
    void makeSound() {
        System.out.println("나무패기가 어려워");
    }
}

class Stone extends Person {
    @Override
    void eat() {
        System.out.println("석공은 맛있는걸 좋아해");
    }
}


public class A_Abstract {
    public static void main(String[] args) {
//        Human human = new Human (); // 인스턴스화 불가능
        // 추상화 클래스는 직접적인 인스턴스화가 불가능함
        Dog dog = new Dog();
        Cat cat = new Cat();

        Namoo namoo = new Namoo();
        namoo.makeSound();

        Stone stone = new Stone();
        stone.eat();

        dog.makeSound();
        dog.eat();

        cat.makeSound();
        cat.eat(); //부모의 메서드 호출됨 (cat 에는 eat 이 없음)

        //추상클래스 또한 클래스 타입으로 활용가능
        //>> 단, 자식만이 가진 멤버(필드, 메서드)에는 접근 불가
        Animal animalDog = new Dog();
        animalDog.makeSound();
        animalDog.eat(); // 자식의 메서드에 접근 => 오버라이딩된 결과가 출력됨
//      animalDog.bark(); => 자식의 메서드에 접근 못함
    }
}
