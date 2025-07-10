package org.example.chapter06;

// == 자바의 변수 숨김과 인스턴스 변수의 독립성 == //

class M {
    String name = "Mammal";
    int age = 10;
    M(String name, int age) {

        this.name = name;
        this.age = age;
    }
}

class C extends M {
    String name = "Cat";
    // C와 M의 name 필드는 서로 독립적인 상태
    // -> 상속 관계에서 인스턴스 변수까지 공유되지는 않음

    //자식클래스에서 동일한 이름의 변수선언 시 변수 숨김(hiding)이 발생함
    // String name = "Mammal" -> 부모변수 숨김처리됨/그러니까 일단 필드는 2개라는거

    //두가지 name 필드의 접근방식
    //1. 부모 Mammal: super.name()
    //2. 자식 Cat : this.name || name 으로 접근

    C(String name, int age) {
        super(name, age);
        //생성자 내에서 호출된 super(name) 을 통해 부모클래스인 Mammal(String name) 생성자를 호출하게 됨
        // 부모의 name만 "나비"로 설정됨

    }
    void displayCat() {
        System.out.println(name); // this.name
        System.out.println(age); // super.age
    }
}

//자바에서는 인스턴스 변수(필드) 가 override되지 않음 => 재정의되지 않음
// >> 그냥 숨김처리되는거임


public class E_Practice {
    public static void main(String[] args) {
        C c = new C("초코", 20);
        c.displayCat();

    }
}
