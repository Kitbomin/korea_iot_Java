package org.example.chapter13;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * === Generic(일반적인) ===
 * : 데이터 타입을 일반화(Generalize)하는 것
 * : 클래스나 메서드를 선언할 때, 구체적인 타입을 명시하지 않고
 *      사용 시점에 지정할 수 있도록 하는 기능
 *      
 * - 같은 코드를 사용 시점에 따라 여러 타입에 맞게 재사용 가능
 * - 미리 타입을 정해놓지 않고 실제 사용 시점에 타입을 결정
 * 
 * 
 * 1. 제네릭의 장점
 * - 타입에 대한 안전성: 컴파일 시 타입 체크 가능, 타입 에러 방지 가능
 * - 코드 재사용성 증가: 하나의 코드로 다양한 타입 사용 가능
 * - 코드 가독성이 증가: 사용 시 명확한 타입 명시로 코드의 의도 파악 가능
 * 
 * 2. 제네릭 사용 방법
 * 1) 제네릭 클래스
 * class 클래스명 <타입 매개변수>  {
 *     // 타입 매개 변수를 사용하는 필드, 생성자, 메서드 작성
 * }
 * 
 * 타입 매개변수(타입변수) -> 코드 작성 시 타입 변수로 클래스나 메서드 내부의 타입을 지정
 *                     -> 해당 기능 사용 시 작성되는 실질적인 타입이 전달
 *          종류
 *          - <T>   : Type 약자, 제일 흔함
 *          - <K, V>: key, value(Map 구조에서 사용)
 *          - <E>   : Element (컬렉션에서 주로 사용)
 * 
 * 2) 제네릭 메서드
 * : 메서드 자체에서 제네릭 타입을 선언하고 사용하는 메서드
 * - 제네릭 타입은 반환 타입, 매개변수, 내부 지역변수 선언 등 다양하게 사용 가능함
 *
 * [접근제한자] <제네릭 타입> 반환타입 메서드명 (매개변수 나열 가능) {구현부}
 * */

class Pair<K, V> {
    private K key;
    private V value;
    
    //생성자
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    //메서드
    public K getKey () {return key;} 
    public V getValue() {return value;}
    
    
    //2) 제네릭 메서드
    //[접근제한자] <제네릭 타입> 반환타입 메서드명 (매개변수 나열 가능) {구현부}
    static <T> void print (T value) {
        System.out.println(value);
    }
    // static 멤버에서는 클래스의 제네릭 타입 매개변수 사용이 불가능 -> 인스턴스 없이 사용 가능하니까!
    // >>> static 메서드는 제네릭 타입을 직접 선언해야함(<T>: 메서드 선언 앞에 필수 명시)
    
    
}


public class A_Generic {
    public static void main(String[] args) {
        
        // === 제네릭 사용 방법 (실질적인 타입 전달) === //

        //제네릭 메서드 사용
        //<제네릭 타입>메서드명();
        Pair.<String>print("안녕");
        
        //오류나는 제네릭 메서드
//        Pair.<Integer>print("안녕");
        //incompatible types: String cannot be converted to Integer

        Pair.<Integer>print(100);

        //타입 명시를 안했는데도 컴파일 오류가 안남
        // -> 자바의 제네릭은 타입 명시를 생략해도 자동으로 타입을 추론함
        Pair.print("Hello"); //T의 String 추론
        Pair.print(200); // T 의 Integer 추론


        // === 제네릭 클래스 사용 === //
        // 클래스명 <필수 명시 - 제네릭타입> 인스턴스명 = new 클래스명<선택적 명시 - 제네릭타입>();
        // : 제네릭 타입의 구조에 값이 들어올 경우 해당 값으로 자동 유추됨 -> 매우매우 편리
        Pair<Integer, String> pair1 = new Pair<>(100, "안녕");
        Pair<Integer, String>pair2 = new Pair<Integer, String>(200, "Hello");

        // +) 제네릭 타입의 경우 기본 타입 직접 사용 불가능
        //      -> Wrapper 클래스 사용
        //         >> int - Integer, double - Double, char - Character ...

        System.out.println(pair1.getKey());
        System.out.println(pair1.getValue());

        Pair<String, Integer>pair3 = new Pair<>("Hi", 999);
//        Pair<int, char> pair4 = new Pair<int, char>();
        // -> 타입 인수는 기본타입일 수 없다.

        //+) 제네릭 타입은 컴파일 이후 실제 타입 정보가 사라지고 Object로 변환됨
        // -> 런타임 시에는 Object로 동작됨
        // ->> 타입 소거(Type Erasure)

        List<String> list = new ArrayList<>();
        list.add("Hello");
        //컴파일 시 리스트 내부요소가 String 타입인지 검사
        // -> 런타임 시에는 List<String>이 List로 취급되고, 타입 정보는 사라짐

        // 타입 소거의 제약 사항
        // list instanceof List<String> => 사용 불가 -> String이 없어지니까
        // - 배열을 제네릭으로 만들 수는 없음 (new T [] => 불가능)

    }
}
