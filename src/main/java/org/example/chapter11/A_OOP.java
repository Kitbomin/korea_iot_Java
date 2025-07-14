package org.example.chapter11;

// === OOP(Object-Oriented Programming) === //
// : 객체 지향 프로그래밍

// === SOLID === //
// : 객체 지향 프로그래밍의 5가지 소프트웨어 개발 원칙

/*
    SRP, OCP, LSP, ISP, DIP
    - 소프트웨어 설계에서 유지 보수성과 확장성을 높여주는 원칙
    - > 다양한 디자인 패턴이랑 구분해서 봐야함 <- 디자인 패턴은 여기서 나왔거등..

    SOLID 원칙 적용 시 주의 사항
    - 적용 순서가 정해져있지 않음
    - 모두 적용할 필요성도 없음
    - 서로 독립적인 개념이 아닌 개념적으로 연관되어있음
    - 상속, 캡슐화, 추상화, 다형성 등은 OOP의 4가지 특성
    - 원칙: Principle P는 다 이 P 씀


    디자인 패턴: 소프트웨어 개발 과정에서 자주 발생하는 문제들에 대한 일반적인 해결책

 */

// 1. SRP : Single Responsibility Principle -> 단일 책임의 원칙
//        - 클래스는 단 하나의 책임만을 가져야 함
//        - 한가지 역할(기능)만 담당 / 하나의 변화 이유만을 가져야 함
//          >> 하나의 클래스가 가지는 하나의 역할과 관련된 변경사항만 클래스에 영향을 미쳐야 함

// 1) 잘못된 설계 예제
class SchoolHelper {
    void cleanClassroom () {
        System.out.println("교실을 청소해줘용");
    }

    void prepareLunch() {
        System.out.println("급식을 준비합니다");
    }

    // 하나의 클래스가 2개의 책임을 가지고 있음
}

// 2) 올바른 설계 예제
class Janitor {
    void cleanClassroom() {
        System.out.println("교실을 청소해용");
    }
}

class LunchStaff {
    void prepareLunch () {
        System.out.println("급실을 준비해줘용");
    }
}

// 위의 두개는 각각 다른 책임을 가지고 있음 -> 이러면 유지보수와 테스트가 쉬워짐

// 2. OCP : Open Closed Principle -> 개방 폐쇄의 원칙
//        - 소프트웨어 엔티티(클래스, 모듈, 함수 ....) 는 확장에는 열려있어야 하고, 수정에는 닫혀있어야 함

// 1) 잘못된 설계 예제 - 새로운 학생 유형이 생길 때 마다 분기문을 더 작성해야함 -> 기존코드 계속 수정해야함
class LunchMenu {
    void serveLunch(String studentType) {
        if (studentType.equals("일반 학생")) {
            System.out.println("알러지가 없어용");
        } else if (studentType.equals("땅콩 알러지")) {
            System.out.println("땅콩 알러지가 있습니다");
        }
    }
}

// 2) 올바른 설계 예제
interface LunchMenuInterface {
    void serveLunch();
}
class RegularStudent implements LunchMenuInterface{
    @Override
    public void serveLunch() {
        System.out.println("일반 학생 - 알러지 없음");
    }
}
class VegetableStudent implements LunchMenuInterface{
    @Override
    public void serveLunch() {
        System.out.println("채식 학생 - 샐러드를 제공합니당");
    }
}

class AllergyStudent implements LunchMenuInterface {
    @Override
    public void serveLunch() {
        System.out.println("알러지 학생 - 특별 배식필요");
    }
}

// 변화가 발생 해도 LunchMenu 인터페이스를 구현한 클래스만 추가하면 됨(확장)
// >> 추상 클래스와 인터페이스를 사용해 상속, 구현을 통한 클래스 관계 구축을 하면 수정에 폐쇄적인 개발이 됨

// 3. LSP : Liskov Substitution Principle -> 리스코프 치환 원칙
//        - 상위 클래스의 객체를 하위 클래스의 객체로 치환하더라도 프로그램의 동작이 일관되게 유지되어야 함
//        - 자식 클래스는 부모 클래스의 기능을 완전히 대체할 수 있게 설계 
//          >> 업 캐스팅 상태에서 부모의 메서드 사용 시 동작이 가능

// 1) 잘못된 설계 예제
class Student {
    void playSoccer() {
        System.out.println("축구를 할 수 있어용");
    }
}

class InjuredStudent extends Student {
    @Override
    void playSoccer() {
        System.out.println("다쳐서 축구를 할 수 없어용"); // 부모가 가진 기능의 일관성이 없음
    }
} // Student의 동작과 InjuredStudent 가 서로 다른 행동을 하고 있음 -> 치환 안됨

// 2) 올바른 설계 예제
abstract class StudentAbstract {
    abstract void activity();
}

class SoccerPlayer extends StudentAbstract {
    @Override
    void activity() {
        System.out.println("축구를 합니당");
    }
}

class InjuredSoccerPlayer extends StudentAbstract{
    @Override
    void activity() {
        System.out.println("다쳐서 축구를 못해요. 재활을 하세요");
    }
}
// 이러면 부모의 activity 라는 추상메서드를 자식의 의도에 맞게 재정의하고있음을 알 수 있음




public class A_OOP {
    public static void main(String[] args) {

    }

}
