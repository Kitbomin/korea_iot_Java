package org.example.chapter14;

/*
 * === 람다 (표현) 식 Lambda Expression ===
 *
 * : 함수형 인터페이스 "구현" 에 사용(자바 8버전부터 도입)
 * - 함수를 하나의 식으로 간결하게 표현
 * - 익명 클래스를 대체하여 코드의 가독성을 향상시켜줌
 *
 * 함수형 인터페이스
 *      : 추상 메서드가 단 하나만 존재하는 인터페이스
 *      - 인터페이스에 @FunctionalInterface 어노테이션으로 사용 가능
 *      - 디폴트 메서드, static 메서드는 여러개 존재해도 상관없음
 *
 */

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface //재정의하지 않는 추상 메서드 여러 개가 MyFunctionalInterface 에서 발견되었습니다 => 추상메서드 하나 지우면 오류 제거 가능
interface MyFunctionalInterface {
    void doSomething();
//    void anotherSomething();
    // 함수형 인터페이스는 단 하나의 추상메서드를 가짐. 여러개 안됨.
}

/*
 * 1. 람다식 기본 형태
 *
 * +) 메서드 기본 형태
 * [접근제어자] 반환타입 메서드명(매개변수 ...) {
 *      구현부
 * }
 *
 * == 람다식 ==
 * : 추상 메서드를 [간결하게] 구현하는 것이 목표
 *
 * +) 인터페이스의 추상 메서드 - public, abstract 생략
 *
 * 형태
 *  - (매개변수) -> {구현부(실행문)};
 *      >> 매개변수: 인터페이스의 메서드 매개변수와 동일
 *      >> -> 연산자(화살표 연산자): 화살표로 매개변수와 실행문을 구분
 *      >> 실행문: 메서드 몸체, {}(스코프)블록
 *
 * => 진짜 다 생략해버리는 기적의 문법...
 */

// == 람다식 사용 예제 == //
// 1) 기본 표현: 여러 개의 매개변수, 하나의 실행문
@FunctionalInterface
interface Calculator {
    int add(int a, int b); //여러개의 매개변수
}

// 2) 매개변수가 없는 경우
@FunctionalInterface
interface NoParams {
    void sayHello();
}

// 3) 매개변수가 한개인 경우 - 소괄호 생략 가능
@FunctionalInterface
interface OneParams {
    void print(String message);
}

// 4) 실행문이 여러 줄인 경우
@FunctionalInterface
interface Operation {
    void operate(int a, int b);
}

// 5) 반환 값이 있는 경우
@FunctionalInterface
interface StringLength {
    int getLength (String str);
}


public class D_Lambda {
    public static void main(String[] args) {

        System.out.println(" === 1) 익명 클래스를 사용한 추상 메서드 구현 === ");
        // Calculator 구현
        Calculator calculator1 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        }; //끝나면 세미콜론
        System.out.println("익명 클래스 결과: " + calculator1.add(3,5));

        System.out.println(" === 람다식을 사용한 추상 메서드 구현 === ");
        // Calculator 람다식 사용 구현
        Calculator calculator2 = (a,b) -> {
            int result = a + b;
            return result; //이런건 중괄호 생략 불가능 | 반환값도 반드시 return 사용해야함
        };

        System.out.println("람다식 결과 1: " + calculator2.add(4,9));

        // 람다식의 경우 구현부가 한 줄 일 때 중괄호 생략이 가능
        // >> 근데 이제 return 키워드 까지 빼버린...(값은 곧바로 반환됨)

        // Calculator 구현부 한줄
        Calculator calculator3 = (a, b) -> a + b;

        System.out.println("람다식 결과 2: " + calculator3.add(7,8));

        // ------------------------------------------- //

        System.out.println(" === 2) 매개변수가 없는 추상 메서드 표현(람다식) === ");
        NoParams noParams1 = () -> {
            String a = "HI";
            String b = "Hello";
            System.out.println(a + b);
        };
        noParams1.sayHello();

        NoParams noParams2 = () -> System.out.println("매개변수도 없도 반환값도 없음");
        noParams2.sayHello();
        // 매개변수가 없는 경우 () 소괄호 생략 불가능

        // ------------------------------------------- //

        System.out.println(" === 3) 매개 변수가 하나인 추상 메서드 표현(람다식) === ");
        OneParams oneParams = message -> System.out.println("출력: " + message);
        /// 이건 진짜 이단이다...
        oneParams.print("안녕");

        // ------------------------------------------- //

        System.out.println(" === 4) 실행문이 여러 줄인 추상 메서드 표현(람다식) === ");
        Operation operation = (a, b) -> {
            System.out.println("합: " + (a + b));
            System.out.println("차: " + (a - b));
        };
        operation.operate(6,2);

        // ------------------------------------------- //

        System.out.println(" === 5) 반환값이 있는 추상 메서드 표현(람다식) === ");
        StringLength stringLength = str ->  str.length();
        // 실행문이 한줄 : return + {} 생략 가능
        // +) 여러 줄일 경우 : 둘 다 생략 불가

        System.out.println("문자열의 길이: " + stringLength.getLength("Lambda"));

        // ------------------------------------------- //

        System.out.println(" + 번외 ");
        //여러줄의 코드가 실행문에 작성될 경우
        //: 리스트 순회
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers);

        for (Integer num: numbers) {
            System.out.println(num);
        }

        numbers.forEach(num -> System.out.println(num)); ///이단이다 이단이야 아아아ㅏ앙ㄺ
    }
}
