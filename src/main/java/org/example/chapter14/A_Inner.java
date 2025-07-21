package org.example.chapter14;

/**
 * chapter 14
 *
 * 내부 클래스(Inner Class) >> 익명클래스(Anonymous Class) >> 람다식(Lambda)
 * +) 람다식을 많이 활용하는 Stream API
 */

/**
 * 내부 클래스(Inner Class) or 중첩클래스(Nested Class)
 * : 다른 클래스 내부에 선언된 또 다른 클래스를 의미
 * - 즉, 클래스 안의 클래스
 *
 * Class Outer Class {
 *     class InnerClass {}
 * }
 *
 * 내부 클래스 사용 목적
 * 1. 코드 가독성 향상 -> 코드의 구조 파악에 용이
 * 2. 캡슐화 강화 -> 외부에 공개할 필요가 없는 클래스는 내부로 감출 수 있음
 * 3. 외부 클래스 멤버 접근 용이 -> 내부 클래스는 외부 클래스의 필드와 메서드에 직접적인 접근이 가능함
 *
 * 내부 클래스 종류
 * 1. (비정적, instance)내부 클래스
 *  : "외부 클래스의 인스턴스" 에 속함
 *  >> 외부 클래스 인스턴스를 먼저 생성해야함
 *  >> 외부 클래스의 인스턴스 멤버(필드, 메서드)에 접근이 가능함
 *
 * 2. 정적(static) 내부 클래스
 *  : "외부 클래스의 정적멤버" 에 속함
 *  >> 외부클래스 인스턴스 없이 생성 가능
 *  >> 외부 클래스의 정적 멤버에만 접근 가능(인스턴스 불가능)
 *
 * 3. 메서드 내부 클래스(지역 클래스)
 *  : "메서드 내에서 정의된 내부 클래스"
 *  >> 해당 메서드 내에서만 사용 가능
 *  >> 메서드의 지역 변수에만 접근 가능함
 *  >> *로컬 변수(외부 클래스의 멤버 변수)가 final인 경우에만 접근이 가능함
 *
 *
 * 4. 익명 (내부) 클래스
 *  : 이름이 없는 내부 클래스
 *  - 주로 인터페이스나 추상클래스의 구현에 사용됨
 *  -> 즉시 객체 생성을 하거나, 일회성 사용에 쓰임
 *
 */

class OuterClass{
    private String outerField = "외부 클래스의 인스턴스 필드";
    static String staticField = "외부 클래스의 정적 필드";

    //1. 내부 클래스 - 인스턴스 멤버처럼 사용
    class InnerClass {
        void display() {
            // 외부 클래스의 인스턴스 멤버에 접근 가능
            System.out.println("외부 클래스 필드에 접근" + outerField);

            // 외부 클래스의 정적 멤버 사용시: 클래스명 생략 가능
            System.out.println("외부 클래스 정적 필드에 접근" + staticField);
        }
    }

    //2. 정적 내부 클래스 - 인스턴스화 없이 사용 가능
     static class StaticClass {
        void display() {
            // 외부 클래스의 인스턴스 멤버 접근
//            System.out.println("외부 클래스 필드에 접근" + outerField); //인스턴스 필드에 접근 못해서 오류남

            // 외부 클래스의 정적 멤버 접근
            System.out.println("외부 클래스 정적 필드에 접근" + staticField);
        }
    }

    //3. 메서드 내부 클래스(지역클래스)
    void outerMethod() {
        // * 지역 변수는 암묵적으로 final로 간주(생략 가능)
        //   >>> 재할당이 이루어지면 final이 사라짐(final로 취급이 안됨)

        String localvar = "메서드 로컬 변수";

//        localvar = "메서드 로컬 변수값 변경";

        final String localFinalVar = "메서드 로컬 변수(final)";

        class MethodClass {
            void display() {
                System.out.println("로컬 변수에 접근 (Final이 아닌): " + localvar); // 유사 final
                //변수 'localvar'은(는) 내부 클래스 내에서 액세스되므로 final 또는 유사 final이어야 합니다 => 지역 변수내에서 재할당이 안됨 ? -> final로 취급
                System.out.println("로컬 변수에 접근 (Final인): " + localFinalVar); //
            }
        }

        System.out.println("외부 클래스의 메서드를 호출");

        //로컬 클래스의 인스턴스화
        // : 메서드 내부에서만 쓰이기 때문에 인스턴스화도 내부에서 일어남
        MethodClass methodClass = new MethodClass();
        methodClass.display();
    }
}


// 익명클래스 내용 ㄱ
// 추상 클래스(하나 이상의 추상 메서드 포함)
abstract class AbstractClass {
    // 추상 클래스는 구현 메서드를 가질 수 있음 -> 그래서 추상메서드에 abstract 생략이 불가능

    abstract void display ();
}

// 인터페이스
interface InterfaceClass {
    // 인터페이스는 일반 구현 메서드를 가질 수 없음 -> 추상 메서드에 abstract 생략이 가능
    void something();

    //필드: public static final 생략
    //메서드: public abstract 생략

    // +) static 메서드, default 메서드는 구현 가능(예외 -> 이것도 된지 얼마 안됨)
}
//ㄴ 익명 클래스 내용


public class A_Inner {
    public static void main(String[] args) {
        System.out.println(" === 비정적 내부 클래스 === ");
        //1) 외부 클래스 인스턴스화
        OuterClass outerClass1 = new OuterClass();

        //2) 외부 클래스의 인스턴스 처럼 사용 가능 -> 외부클래스객체명.클래스호출
        //외부클래스 타입.내부클래스타입 변수명 = 외부클래스인스턴스.new 내부클래스();
        OuterClass.InnerClass innerClass = outerClass1.new InnerClass();

        innerClass.display();

        System.out.println(" === 정적 내부 클래스 === ");
        // 1) 외부 클래스 인스턴스화 필요 없음 ex OuterClass outerClass2 = new OuterClass();
        // 외부클래스타입.내부클래스타입 변수명 = new 외부클래스명.내부클래스();
        OuterClass.StaticClass staticClass = new OuterClass.StaticClass();

        staticClass.display();

        System.out.println(" === 메서드 내부 클래스(지역 클래스) === ");
        OuterClass outerClass2 = new OuterClass();
        outerClass2.outerMethod();
    }
}
