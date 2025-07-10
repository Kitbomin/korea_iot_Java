package org.example.chapter06;

// 상속에서의 생성자
// : 상속받은 클래스에서 생성자를 호출하면 -> 부모에서 자식 순서로 호출됨
// >>> 자식클래스에서 객체 생성시, 자식 클래스는 해당 클래스의 생성자를 통해 객체가 생성될거임
//     >> 자식클래스의 생성자 호출시 '반드시' 부모클래스의 생성자가 호출되어야함
//        - 반드시 부모가 존재해야만 자식이 존재할 수 있음 (사용자 정의일 필요는 없음)

class A {
    A () {} //빈생성자 - 사용자 정의 생성자가 없으면 이게 기본 생략되어있음
    A(int a) {
        this(); // => 반드시 최상단에 명시되어있어야함
        System.out.println(a);
    }
}

class Mammal {
    String name = "Parent";

    Mammal() {
        super();
        System.out.println("빈 부모 생성자 - 인스턴스 생성");

    }

    Mammal(String name) {
        this.name = name;
    }

    void displayMammal() {
        System.out.println(name);
    }
}

class Cat extends Mammal {
    String name = "Child";
    // 상속 받은 자식 클래스는 사용자 정의 부모 생성자의 호출이 없더라도 호출 가능
    // -> super() 라는게 정의되어있음 (기본생략)

    Cat () {
        super(); // -> 이게 생략되어있어도 자동 호출이됨.
        // >> Mammal 클래스 내에 매개변수가 없는 생성자를 호출하고 있음
    } // 얘가 생략되어있을거임

    Cat(String name) {
        super(name);
        //super 메서드는 부모클래스의 생성자를 가져오는 키워드.
        //      => 부모 클래스 내에 정의된 생성자를 형태 그대로 사용
        //      => 여러개의 생성자가 있는 경우 (오버로딩) super의 형태가 다양해질 수 있음
//        this.name = name;
    }

    void displayCat() {
        //해당 클래스가 가진 인스턴스 변수에 접근: this
        // >> 생략 가능(지역변수와 충돌이 나지 않는 경우만)
        System.out.println("자식이름 " + name);
        System.out.println("자식이름 " + this.name);

        //부모 클래스가 가진 인스턴스 변수에 접근 : super()
        // >> 생략 불가능
        System.out.println("부모이름 " + super.name);
    }

}

// super
// : 부모클래스로 생성된 객체 그 자체
//   - 부모 클래스 내의 필드와 메서드에 접근(.연산자)
//   - super.필드명; / super.메서드명(); / super(); -> 부모클래스 내의 생성자호풀


public class C_Inheritance {
    public static void main(String[] args) {

        Cat cat1 = new Cat();

        Cat cat2 = new Cat("나비");
        System.out.println(cat2.name);

        cat2.displayCat();

    }

}
