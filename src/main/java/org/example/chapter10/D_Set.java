package org.example.chapter10;

/*
    === set Interface ===
    : 중복이 되지 않음, 순서도 지정되지 않음
    - 중복된 요소를 포함하지 않는 객체의 집합
    - 객체가 저장 순서를 가지지 않음(삽입된 순서가 유지되지 않음)
    - null 요소 또한 포함 가능

    List 는 중복 가능, 순서도 있음 null 포함 가능 || Set은 중복 안됨, 순서도 없음, null 포함 가능

    ==구현체==
    1. HashSet
     : 가장 많이 사용되는 set 구현체
     - 빠른 데이터 접근과 삽입이 지원됨
     - 하지만 정렬, 순서 보장이 되지 않음


    2. LinkedSet
     : HashSet + 순서는 가짐 ( 해쉬셋의 순서보장이 안되는걸 보완함 -> 기능 확장 )
     - 중복 안됨, 순서 보장

    3. TreeSet
     : 데이터가 자동 정렬 -> 중복 제거와 정렬된 순서 유지가 필요한 경우 사용
     - 중복 안됨, 순서 보장

 */

import java.util.HashSet;
import java.util.Set;

public class D_Set {
    public static void main(String[] args) {
        // == Set 컬렉션의 주요 메서드 == //
        // add, remove, contains, size, isEmpty

        Set<String> students = new HashSet<>();

        students.add("정지훈");
        students.add("정은혜");
        students.add("최광섭");
        students.add("손태경");

        System.out.println(students); //삽입된 순서대로 나오지 않음 -> 순서 보장 안됨

        students.add("정은혜");
        System.out.println(students); //중복된 데이터는 제거됨
        
        boolean result = students.remove("최광섭"); // 제거 후 완료 여부가 불리언값으로 출력
        System.out.println(result);
        System.out.println(students);

        boolean falseResult = students.remove("이승아"); //없는 값 지우려하면 false값 내놓음
        System.out.println(falseResult);
        System.out.println(students);

        System.out.println(students.size());

        System.out.println(students.contains("손태경")); // 이것도 불리언 값으로 출력
        System.out.println(students.contains("조승범"));

        System.out.println(students.isEmpty()); //해당 리스트가 비었니?
        students.clear();
        System.out.println(students.isEmpty());

    }
}
