package org.example.chapter14;
//메서드 참조

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * === 메서드 참조 ===
 * : 람다 표현식을 더 간단하게(!?!) 작성하기 위한 문법
 * - 메서드 호출만 하는 단순한 람다일 경우, 메서드 이름만으로 표현이 가능함
 *
 *
 * +) 람다 표현식
 * : 익명 함수 작성 방법으로 함수형 인터페이스를 간단하게 구현 가능
 * (매개변수) -> {실행문}
 *
 *
 * == 메서드 참조 종류 ==
 *
 * 1. 정적 메서드 참조
 *  - 클래스의 static 메서드 참조
 *  - Math.random() => 정적 메서드임
 *
 *  -형식
 *  ClassName.staticMethod();  === > ClassName::staticMethod;
 *  냅다 호출부를... 없애버리네
 *
 * 2. 인스턴스 메서드 참조
 *  - 객체(인스턴스)를 반드시 생성해 사용하는 메서드
 *  - 특정 객체의 인스턴스 메서드를 참조
 *
 *  - 형식
 *  instance.instanceMethod(); === > instance::instanceMethod;
 *
 *
 * 3. 생성자 메서드 참조
 *  - 객체 생성용 생성자 참조
 *
 *  - 형식
 *  new ClassName(); ===> ClassName::new
 *
 *
 * 4. 임의 객체의 인스턴스 메서드
 *  - 특정 객체가 아닌 여러 객체에 공통된 인스턴스 메서드를 사용할 때 쓰임
 *  ex) 모든 객체가 Object 내의 인스턴스 메서드를 포함할 때
 *
 *  - 형식: ClassName::instanceMethod;
 *
 */

class StaticMethod {
    // 정적 메서드: 인스턴스 없이 바로 사용가능
    static int doubleValue(int x) {
        return x * 2;
    }
}

class Person {
    //생성자 메서드
    private String name;

    public Person() {
        this.name = "이름 미상";
    }

    public Person(String name){
        this.name = name;
    }

    public String getName() {return name;}
}

public class G_MethodRef {
    public static void main(String[] args) {

        // 1. 정적 메서드 참조
        // 1) 람다 표현식
        Function<Integer, Integer> doubleLambda = x -> StaticMethod.doubleValue(x);
        // 2) 메서드 참조
        Function<Integer, Integer> doubleLambdaRef = StaticMethod::doubleValue;

        System.out.println(doubleLambda.apply(5));
        System.out.println(doubleLambdaRef.apply(10));


        
        // 2. 인스턴스 메소드 참조
        // 문자열 객체의 메서드 사용 ==> Object를 상속받는 String 클래스는 선언 시 객체 생성이 이루어짐
        //                              String 클래스 내부 인스턴스 메서드가 사용 가능함
        String hello = "Hello";
        // 1) 람다 표현식
        Supplier<String> toUpperLambda = () -> hello.toUpperCase();
        // 2) 메서드 참조
        // 이미 생성된 객체의 메서드를 참조함
        Supplier<String> toUpperLambdaRef = hello::toUpperCase;

        System.out.println(toUpperLambda.get());
        System.out.println(toUpperLambdaRef.get()); // -> 이미 변환된 애를 가져옴


        // 3. 생성자 참조
        // 1) 람다 표현식
        Supplier<Person> personLambda = () -> new Person("나나나");
        Supplier<Person> personLambda2 = () -> new Person();
        // 2) 메서드 참조: !!매개변수가 없는 생성자일 경우에만 활용이 가능함!!
        Supplier<Person> personLambdaRdf = Person::new;

        Person p1 = personLambda.get();
        Person p2 = personLambdaRdf.get();

        System.out.println(p1.getName());
        System.out.println(p2.getName());


        
        // 4. 임의 객체 인스턴스 메서드 참조
        String[] names = {"Ben", "dokyeong", "sangsang"};

        // Function<String, String> toUpperFunc = s -> s.toUpperCase();
        Function<String, String > toUpperFunc = String::toUpperCase; //위에꺼를 이렇게 바꿀 수가 있다고오오

        for (String name: names) {
            // 호출 시점(apply)에 매개변수로 들어온 객체의 메서드를 호출
            String upper = toUpperFunc.apply(name);
            System.out.println(upper);
        }
    }
}
