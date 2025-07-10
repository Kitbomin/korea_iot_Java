package org.example.chapter08;

// 인터페이스의 멤버 변수의 특성 //
// : 자동으로 public static final의 특성을 가짐 
//   > 어디서든 접근이 가능 + 모두 같은 값 공유 (인스턴스화 없이 인터페이스에 접근 가능) + 불변성

// 클래스 || 인터페이스의 멤버 : 해당 구조의 내부 구성요소를 뜻함

// === 다중 인터페이스 구현 === //

interface Example1 {
    int EXAMPLE_VARIABLE = 10;
    
    void printVar1();
    
    default void method() {
        System.out.println("예시 1");
    }
}

interface Example2 {
    void printVar1();
    void printVar2();
    
    default void method(){
        System.out.println("예시 2");
    }
}

// 여러개의 인터페이스 구현 방법
// implements 키워드 뒤에 여러개의 인터페이스를 콤마로 구분해 나열
class ExampleClass implements Example1, Example2 {
    //동일한 이름의 추상메서드를 구현 가능함 => 어차피 재정의 할거니까.
    // 다중 인터페이스 구현시 동일한 추상 메서드명 재정의 가능
    
    @Override
    public void printVar1() {
        System.out.println(EXAMPLE_VARIABLE);
    }

    @Override
    public void printVar2() {
        //해당 메서드의 추상 메서드 클래스에서 상수값이 없더라도 사용 가능함
        System.out.println(EXAMPLE_VARIABLE);
    }

    // 재정의 어노테이션(@Override)
    // : 어노테이션은 자바 컴파일러에게 주는 설명과도 같음

    //다중 인터페이스 구현시 같은 시그니처를 가진 디폴트 메서드가 존재할 경우
    // - 반드시 오버라이드 어노테이션을 작성해야함

    @Override
    public void method() {
        System.out.println("Method, 중복되는 디폴트 메서드");
    }

}

public class E_Interface {
    public static void main(String[] args) {
        ExampleClass exampleClass = new ExampleClass();
        exampleClass.printVar1();
        exampleClass.printVar2();
        exampleClass.method();

        Example1 example1 =  exampleClass; //=> 업캐스팅시킴 //new로 재정의하면 안됨
        example1.printVar1();
//        example1.printVar2(); => Example1에 정의되지 않음
        example1.method();

        //인터페이스의 다형성
        //: 인터페이스로 구현한 클래스의 객체는 해당 인터페이스 타입으로 동작함 >> 업캐스팅의 일부
        //  - 해당 인터페이스 내의 구조만 가짐(추가구현된 기능은 읽히지 않음)
        //  - 재정의된 메서드로 유지됨
    }
}
