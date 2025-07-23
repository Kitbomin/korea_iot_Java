package org.example.chapter15;

import java.util.Optional;

/**
 * === Optional 클래스 ===
 * : 값이 존재할 수도 있고, 없을 수도 있는 객체를 감싸는 컨테이너(자바 8버전 이후)
 * - null 값을 다룰 때 발생하는 NullPointerException(NPE) 를 방지함
 * - null 체크를 명시적으로 안전하게 처리함
 * +) 함수형 프로그래밍 스타일 지원
 *
 *
 *
 */

class Person {
    String name;

}

public class E_Optional {
    static String findNameById(int id){
        return null; //실제 DB나 Map에서 검색 가정 >> 못 찾은 경우 null 반환
    }


    public static void main(String[] args) {
        // NPE: null에 참조된 객체에 접근할 때 발생하는 예외
        String name = null;
//        System.out.println(name.length()); //컴파일 오류는 발생하지 않지만, 실행오류는 남

        Person p = null;
//        System.out.println(p.name);

        String[] arr = new String[3];
        arr[0] = "abc";
        // arr[1]과 arr[2]는 기본값이 null인 상태
//        System.out.println(arr[1].toUpperCase());

        String result = findNameById(123);
//        System.out.println(result.toUpperCase());


        // 1. Optional 클래스
        //  : null이 아닌 값을 포함하거나 값이 없는 상태를 나타낼 수 있음
        //  - 값을 명시적으로 검사하고 처리하는 방식

        // 2. Optional<T> 생성 방법

        // 1) Optional.of(T value) : null이 아닌 값을 감쌈(null 전달 시 NPE 발생)
//        Optional<String> optional0 = Optional.of(null); => NPE 발생
        Optional<String> optional1 = Optional.of("Hello Optional");


        // 2) Optional.ofNullable(T value): null 여부 상관 없이 Optional 생성 (null인 경우엔 빈 Optional 생성)
        Optional<String> optional2 = Optional.ofNullable(null);


        // 3) Optional.empty(): 비어있는 Optional 생성 (명시적으로 "값 없음" = null을 표현)
        Optional<String> optional3 = Optional.empty();


        // 3. Optional 값 확인 메서드
        // 1) isPresent(): 존재하는가? | 값이 존재하면 True, 존재하지 않으면 False
        // 2) isEmpty(): 값이 존재하지 않니? | 값이 존재하면 False, 존재하지 않을 경우 True

        System.out.println(optional1.isPresent());
        System.out.println(optional1.isEmpty());

        System.out.println(optional2.isPresent());
        System.out.println(optional2.isEmpty());


        // 4. Optional 값 추출 메서드
        // .get() 메서드 => 값이 없는 상태(null)에서 호출 시 예외 발생

        System.out.println(optional1.get());
//        System.out.println(optional2.get()); => NoSuchElementException 발생 => 가져올 값을 검색하지 못했어용

        // 5. Optional 기본값 처리
        //      >> 값을 확인하고 존재하면 반환, 존재하지 않으면(빈 Optional인 경우) 경우에 따라 값을 반환 || 예외발생


        // 1) .orElse(T other): 값이 없을 경우 기본값(other) 반환
        System.out.println(optional2.orElse("기본값 반환"));

        // 2) .orElseGet(Supplier<T>): 값이 없을 경우 함수형 인터페이스로 값을 생성해 반환
        System.out.println(optional2.orElseGet(() -> "값을 생성해 반환"));

        // 3) .orElseThrow(Supplier<throwable>): 값이 없을 경우 예외 발생

        //+) Supplier<T>: 공급하다 -> T 타입의 값을 생성해 반환

        try {
            optional3.orElseThrow(() -> new Error("값이 없을 경우 예오 ㅣ발생")); //Exception in thread "main" java.lang.Error: 값이 없을 경우 예오 ㅣ발생
        }catch (Error e) {
            System.out.println("예외가 발생해버렸어요: " + e.getMessage());
        }


        // +) Optional 사용 시 주의 사항
        // 1) 필드에 사용하지 않음

        // 2) 메서드 매개변수로 사용하지 않음 -> 변수형태로 안씀
        //      >> 반환값으로 사용(메서드 호출 결과가 null일 수도 있는 경우에만)

        // 3) 값이 반드시 존재해야하는 경우 사용하지 않음
        //      >> null 방지에 대한 필수값은 직접 값을 반환하고 null 여부를 확인하는게 맞음





    }
}
