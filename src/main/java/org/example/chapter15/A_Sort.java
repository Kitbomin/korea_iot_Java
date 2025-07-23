package org.example.chapter15;

/*
* === Stream API ===
* 1. 스트림 생성: .stream()
*
* 2. 중간 연산(가공절차)
*       - .map(Function: 입력값을 받아 특정 연산 후 반환)
*       - .filter(Predicate: 입력값을 받아 조건을 검사
*       - .sorted(Comparator: 입력값에 대한 비교)
*
* 3. 최종(결과) 절차
*       - collect
*       - forEach
* */

/*
* === 자바의 정렬 ===
* 1. 정렬
*  : 데이터를 특정 기준(순서)에 따라 나열
*    Ex) 오름차순(1~, ㄱ~, ㅏ~, a~)
*        내림차순(큰수부터, ㅎ~, ㅣ~, z~)
*        문자열 길이 순 정렬(a, aa, aaa) => 같은 문자끼리는 길이 순서대로 정렬
*
* 2. 배열(Arrays 클래스) 정렬
*  : Arrays 클래스의 정적인 메서드인 .sort() 사용
*    >> 오름차순 정렬만 지원
*       만약 내림차순 정렬을 하고싶다 -> Collections 클래스 사용 .reverseOrder() 정적 메서드 사용
*
* 3. 리스트(List 인터페이스) 정렬
*  : Collections.sort 사용 또는 List 인터페이스의 sort() 메서드 사용
*
* */


import java.util.*;
import java.util.stream.Collectors;

public class A_Sort {
    public static void main(String[] args) {
        //[1] 배열 정렬
        // == 오름차순 ==
        int [] numbers = {5,3,2,7,1};
        Arrays.sort(numbers);
        System.out.println(numbers); //주소값
        System.out.println(Arrays.toString(numbers));

        // == 내림차순 ==
        //: Collections 클래스의 reverseOrder()
        // >> Comparator<T>를 반환하는 메서드(객체 타입간의 비교 - 기본 데이터 타입을 비교하지 않음
        // wrapper을 배운 이유 -> 객체 타입간의 비교를 하기 때문 -> int, double 이런거 안됨 Integer 이런거 써야함
        Integer[] nums = {5,3,2,7,1};
        Arrays.sort(nums, Collections.reverseOrder());

        System.out.println(nums[0]);
        System.out.println(nums[4]);
        System.out.println(Arrays.toString(nums));


        // [2] 리스트 정렬
        // == 오름차순 ==
        List<Integer> list = new ArrayList<>(List.of(4,2,6,1,3));
        Collections.sort(list);
        list.sort(null);
        //위으 ㅣ두 개 모두 값이 같음
        System.out.println(list);

        // == 내림차순 ==
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // 번외: Comparator 클래스
        //: 사용자 정의 기준 정렬
        List<String> names = new ArrayList<>(List.of("Tom", "Jerry", "Pororo", "Loopy"));

        // 문자열 길이 순 정렬
        // 전체 순회 -> 각 이름의 길이를 반환 -> 그 길이로 오름차순 정렬

        names.sort(Comparator.comparingInt(name -> name.length()));
        names.sort(Comparator.comparingInt(String::length));

        System.out.println(names); //문자열 길이 순으로 정렬됨

        // Comparator: 두개의 객체를 비교하는 로직을 담는 인터페이스
        //      >> 어떠한 기준으로 정렬할지 개발자가 결정할 수 있음


        // [3] Stream API 사용 정렬
        // : 정렬된 결과를 새로운 컬렉션으로 반환 가능
        List<Integer> listNumber = new ArrayList<>(List.of(7,2,4,5,1));

        List<Integer> sortedNumber = listNumber.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNumber);
        System.out.println(listNumber);

        // !!! Stream API는 원본 데이터를 건들지 않고, 새로운 컬렉션으로 출력됨 => 원본 데이터에 대한 불변성이 유지됨
        //     새로 정렬된 리스트를 반환해줌

        // == 내림차순 ==
        List<Integer> sortedReverseNumber = listNumber.stream()
                .sorted((a,b) -> b -a) //내림차순 로직
                .collect(Collectors.toList());

        // 내림차순 정렬 식
        // (a, b) -> b - a
        // : a와 b는 리스트 안의 두개의 요소(순차적으로 담김)
        // - 두 요소를 비교한 결과를 반환
        //  1) 반환값이 양수 : b가 a보다 앞에옴
        //  2) 반환값이 0 : 순서 변경이 일어나지 않음
        //  3) 반환값이 음수 : a가 b보다 앞에옴

        //  +) 오름차순: ( (a, b) -> a-b ) 로직 처리


        // + 알고리즘을 보아하니 이것은 순차 정렬이로군


        List<String> charNames = new ArrayList<>(List.of("Tom", "Jerry", "Pororo", "Loopy"));

        List<String> sortedChar = charNames.stream()
                //캐릭터 이름 길이로 오름차순
//                .sorted((n1, n2) -> n1.length() - n2.length())
                //캐릭터 이름 길이로 내림차순
                .sorted((n1, n2) -> n2.length() - n1.length())
                .collect(Collectors.toList());

        System.out.println(sortedChar);



    }
}
