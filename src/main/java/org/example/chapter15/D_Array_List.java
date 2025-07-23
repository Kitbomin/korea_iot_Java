package org.example.chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * === 배열과 리스트에 대한 정리 ===
 * +) 공통점: 순서 O(인덱스 기반, 0부터 시작함), 인덱스 번호로 접근 가능
 *
 * 1. Array(배열)
 *  : 정적 자료구조
 *  : 크기가 고정: 생성 시 지정한 크기에서 변경이 불가능함
 *  : 연속된 메모리 공간에 저장됨
 *  : 데이터가 동일한 타입이어야 함(명시적 데이터여야 할 것)
 *
 *  +) 불편점
 *     원소 추가, 삭제가 번거로움 -> 직접 구현해야함
 *
 * 2. List(리스트)
 *  : 동적 자료구조
 *  : 크기가 가변적
 *  : 메모리 공간이 불연속적임
 *  : 다양한 구현체가 존재함
 *      - ArrayList, LinkedList ...
 *
 *  +) List<> 컬렉션 프레임워크는 불변 리스트, 가변 리스트 모두 할당이 가능함
 *
 */



public class D_Array_List {
    public static void main(String[] args) {
        // List 생성 방법

        // 1) new ArrayList<>();
        //      - 가변성 O -> 길이 변경, 수정 가능
        //      - 가장 일반적인 생성자 사용 리스트 생성 방식

        List<String> list = new ArrayList<>();


        // 2) Arrays.asList();
        //      - 가변성 X -> 길이 고정, 수정 가능
        //      - 가짜 ArrayList: Arrays 클래스 내부에서 구현된 별개의 ArrayList임 (컬렉션 프레임워크가 아님)
        //      - 배열을 리스트로 변환

        List<String> asList = Arrays.asList("a","b");


        // 3) List.of();
        //      - 불변성 O -> 길이 고정, 수정 불가
        //      - 읽기 전용 리스트 생성
        //      - null 값을 포함할 수 없음

        List<String> listOfVar = List.of("a","b");

        // 4) Stream.of().collect(Collectors.toList());
        //      - 가변성 O -> 1번과 동일한 형태라 봐도 됨

        List<String> collectVar = Stream.of("a","b").collect(Collectors.toList());


        // 5) List.copyOf();
        //      - 불변성 O -> 길이 고정, 수정 불가
        //      - 기존 리스트의 불변 복사본을 생성함

        List<String> copyVar = List.copyOf(list);


    }
}
