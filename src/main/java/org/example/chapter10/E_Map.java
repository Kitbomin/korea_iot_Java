package org.example.chapter10;

// === Map Interface === //
// : 키와 값 쌍으로 요소르 저장하는 데이터 구조

// - 키(key): 고유한 값을 가져야함. 중복 안됨
// - 동일한 키에 서로 다른 값 전달 시 기존 값이 새로운 값으로 덮어씌워짐

// -- name : "홍길동", name: "전우치" (name 에는 전우치만 존재할 수 있음)
// - 서로 다른 키에 동일한 값은 가능함

// -- name : "개구리" , nickname: "개구리" (이건 가능)

// +) 키의 유일성, 값의 중복성을 보장함
//    >> 순서 보장은 안됨
//    >> 하지만 키를 기반으로 빠른 검색이 가능함'

// === Map 인터페이스 종류(구현체) === //
// 1. HashMap: 가장 많이 사용됨. 키와 값에 null 허용
//    - 빠른 검색, 삽입 성능 제공
//    - 순서 유지는 안됨

// 2. LinkedHashMap: HashMap + 삽입 순서 유지
//    - 삽입 순서가 중요하고 빠른 검색이 필요할 때 사용
//

// 3. TreeMap: 키에 따라 자동정렬 기능이 보장됨
//    - 키에 null값 허용하지 않음


import java.util.*;

public class E_Map {
    public static void main(String[] args) {
        // == Map Interface Method == //
        // Map<키 타입, 값 타입> 인스턴스명 = new Map종류<>();

        Map<String, Integer> studentAges = new HashMap<>();

        //put(키, 값) : 키와 값을 Map에 추가
        studentAges.put("홍기수", 20);
        studentAges.put("김지선", 25);
        studentAges.put("김동후", 30);

        System.out.println(studentAges); //삽입 순서 보장 안됨
        // 중괄호 내의 키=값 쌍이 콤마로 구분되어 나열되어 출력됨

        System.out.println(studentAges.get("홍기수")); //지정된 키의 값 반환
        
        studentAges.remove("김동후"); //지정된 키의 값을 삭제 후 반환
        System.out.println(studentAges);


        //포함된 값인지 확인(불리언) 하는 방법
        System.out.println(studentAges.containsKey("이승아"));
        System.out.println(studentAges.containsValue(30));

        System.out.println(studentAges.containsKey("김지선"));
        System.out.println(studentAges.containsValue(20));

        System.out.println(studentAges.size());

        // KeySet() : Map의 키들을 Set 으로 반환해줌
        System.out.println(studentAges.keySet()); //중복 제거하고 키값 반환해줌

        // Values() : Map의 값들을 Collection 타입으로 반환해줌
        Collection<Integer> listAges = studentAges.values();
        System.out.println(listAges); // 값들만 반환해줌

        // +) Collection 타입은 하위 인터페이스로 변환이 가능함
        List<Integer> changeList = new ArrayList<>(listAges);
        System.out.println(changeList); //데이터 타입이 달라짐

        // entrySet(): Map의 키와 값을 Set 으로 변환시켜줌
        System.out.println(studentAges.entrySet()); // 키=값 으로 출력해줌 (내용물 만)


    }
}
