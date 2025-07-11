package org.example.chapter10;

// === List 인터페이스 === //
// List<User> userList = new ArrayList<>(); => 업캐스팅ㅇ임

// 1. 특징
//  : 순서가 유지(인덱스를 통해 정확한 위치 지정이 가능), 중복저장이 가능
//  - 저장된 순서에 따라 데이터를 관리하는 다양한 메서드를 지원해줌

// 2. 종류

// 1) ArrayList
//  : 내부에서 배열을 사용한 요소를 저장
//  - 빠른 읽기 성능 / 느린 삽입, 삭제
//  - 빠른 조회 기능에 적합, 삽입과 삭제 시 데이터 이동이 필요해 상대적으로 성능이 저하됨
//    => 시간복잡도 생김

// 2) LinkedList
//  : 내부에서 이중 연결 리스트를 사용한 요소를 저장
//  - 빠른 삽입, 삭제 성능 / 느린 읽기 성능
//  - 연결 기반 데이터 관리: 비순차적 데이터 작업에 적합함 | 특정 요소 접근 시 순차 탐색이 필요해 성능이 저하됨

// 너가 알고있는거... 자료구조에서 진짜 지겹게 들은거...

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B_List {
    public static void main(String[] args) {
        // == List 인터페이스 주요 메서드 == //
        System.out.println(" --- ArrayList --- ");

        // List 인터페이스 >> AbstractList 추상클래스 >> ArrayList 클래스
        ArrayList<String> arrayList = new ArrayList<>();

        // 데이터 추가
        arrayList.add("Java"); //리스트 마지막 요소로 저장
        arrayList.add(0, "Python");
        arrayList.add("JavaScript");

        System.out.println(arrayList);

        // 데이터 일ㄹ기
        String firstElement = arrayList.get(0);
        System.out.println(firstElement);

        // 데이터 수정
        arrayList.set(2, "TypeScript");
        System.out.println(arrayList);

        // 데이터 삭ㅈ제 : 해당 인덱스 요소를 삭제한 후 '반환'
        String removedElement = arrayList.remove(1);
        System.out.println(removedElement);
        System.out.println(arrayList);

        // 데이터 크기
        System.out.println(arrayList.size());

        // 데이터 삭제(리스트 비우기)
        arrayList.clear();
        System.out.println(arrayList.size());

        System.out.println(" --- LinkedList --- ");
        LinkedList<String> linkedList = new LinkedList<>();

        //데이터 추가
        linkedList.add("apple");
        linkedList.add("orange");
        linkedList.add("mango");
        linkedList.add(1, "Banana");

        System.out.println(linkedList);

        //데이터 읽기 - 똑같음
        // 데이터 수정 - 똑같음
        // 데이터 삭제 - 똑같음

        //데이터 크기
        System.out.println(linkedList.size());

        //데이터 포함 여부
        // 불리언 값으로 출력됨
        System.out.println(linkedList.contains("orange"));
        System.out.println(linkedList.contains("strawberry"));

        // == ArrayList VS LinkedList 성능비교 == //
        ArrayList<Integer> arrayListTest = new ArrayList<>();

        //클래스 구조의 객체 타입 데이터: 클래스 구조는 객체 타입의 데이터만 삽입가능(Integer, Character, Boolean, Double...)

        long startTime = System.nanoTime();
        //1초 = 1,000,000,000 나노초
        for (int i = 0; i < 222222; i ++) {
            arrayListTest.add(0, i);
        }

        long endTime = System.nanoTime();

        System.out.println("ArrayList 삽입 시간: " + (endTime - startTime) + "ns");

        LinkedList<Integer> linkedListTest = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 222222; i ++) {
            linkedListTest.add(0,i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 삽입 시간: " + (endTime - startTime) + "ns");
    }
}
