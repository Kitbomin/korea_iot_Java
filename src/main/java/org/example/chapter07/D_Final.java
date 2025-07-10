package org.example.chapter07;

// Final 키워드 //
// : 변수, 메서드, 클래스 에서 사용가능
// 1) 변수: 값을 변경할 수 없는 상수 선언을 함
// 2) 메서드: 자식클래스에서 overriding을 못하게 선언함
//           >> 해당 메서드는 재정의 될 수 없음.
// 3) 클래스: 상속될 수 없는 클래스에 대한 선언

class MyFinalClass {
    //1. final 변수: 상수지정, 선언과 동시에 값이 초기화 되어야함 -> 재할당 못하게
    //   - UPPER_SNAKE_CASE 사용(전체 대문자)
    final int FINAL_VARIABLE = 30;

    //2. final 메서드: 자식 클래스에서 오버라이딩을 못하게 선언해놓은 메서드
    //   - [접근제어자] final 반환타입 메서드명() {}
    public final void MyMethod () {
        System.out.println("재정의 할 수 없는 메서드");
    }

}

class ChildClass extends MyFinalClass {
    //상속받은 final 클래스는 재정의 불가
    // : 생략된 형태로만 사용ㅇ 가능
//    @Override
//    public void myMethod() {} => 아예 안됨

    ChildClass() {
        super.MyMethod();
    }
}

//3. final 클래스: 더이상 상속될 수 없는 클래스 의미(부모클래스로 사용할 수 없음 -> 단일 클래스로만 사용 가능)
//   - final class 클래스명() {}

final class Example1 {}
//class Example2 extends Example1 {} => 상속 안됨

class StudentClass {
    private String name; // 보호되고 변경가능함

    private final int residentNum = 0; // 보호되고 변경이 불가능 // 오류가나는 이유는 final의 초기화가 이루어지지 않아서
    // 모든 인스턴스가 고유한 값을 가지는 인스턴스 필드 이면서 private 클래스 내부에서만 접근 가능하고,
    //          한번 값이 할당(초기화)되면 변하지 않는 필드

    // static과 final을 구분가능해야함.

    //final 필드의 데이터 주입(삽입)
    // : final 키워드는 선언과 동시에 초기화가 필요
    //   - 필드 주입방식  => = ~데이터값~
    //   - 생성자 주입방식 =>

    private final String gender; //보호되고 변경이 불가능함

    StudentClass(String gender) {
        this.gender = gender;
    }

    // 데이터의 ㅇ불변성 유지 방법
    // - final 필드 사용 + setter 사용 X + 생성자로만 값을 결정하는 방식 (생성자 주입 방식) 을 많이 사용함


    public String getName () {return name;}
    public void setName (String name) {this.name = name;}
}


public class D_Final {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        childClass.MyMethod();
        System.out.println(childClass.FINAL_VARIABLE);
//        childClass.FINAL_VARIABLE = 20; => 재정의 못함


        // final 장단점
        // 장점) 불변성(안정성을 보장함)
        // 단점) 유연성이 감소(상속도 안되고 오버라이딩도 안되고 재할당도 안됨... -> 그 자체로만 사용 가능함)
    }
}
