package org.example.chapter03;


//자바의 정적배열 >>
//장점 - 기본데이터타입 사용 가능, 요소 접근 속도가 빠름
//단점 - 한번 생성되면 크기를 변경할 수 없음

import java.util.ArrayList;
import java.util.Arrays;

public class E_Array {
    public static void main(String[] args) {
        //자바 정적배열
        int [] numbers = new int[5];
        System.out.println(Arrays.toString(numbers));

        //자바 동적배열
        //자압의 동적배열 구현체 내부적으로 배열을 사용하지만, 자동으로 크기가 조절됨
        //크기 제한 없이 동적으로 요소추가/삭제 가능
        // Java Collection Framework의 일부. java.util.ArrayList에서 제공
        //장점 - 크기 제한이 없다. 다양한 편의 메서드가 존재(add, remove, set ...)
        //단점 - 기본타입 사용이 불가능, 내부적으로는 배열이기 때문에 중간 삽입/삭제 시 성능저하 가능성이 존재함

        //ArrayList => 기본 데이터 타입 사용이 불가능 => 참조데이터타입만 간으 => 그래서 wrapper클래스 사용해야함
        //wrapper? => 자바의 기본타입을 객체 형태로 감싸서 사용할 수 있도록 만든 클래스
        // >> 기본값은 null => 주소값이 비었음
        // int,char 제외 나머지는 시작 알파벳을 대문자로 사용 => Float?
        Integer a = null;

        // ArrayList 생성 //

        //ArrayList<데이터 타입>변수명 = new ArrayList<>(초기 용량);
        //정적배열은 초기 크기값 미지정시 오류남 => 실제 요소값이라도 넣어놔야함

        ArrayList<Integer> arrayList = new ArrayList<>();
        // 초기용량 미지정시 기본값 = 10

        System.out.println(arrayList);

        //1. ArrayList 데이터 추가 => 배열의 마지막에 값을 추가
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println(arrayList); //내부 데이터를 확인하기 쉽게 문자열로 정리된 형태를 제공, toString을 재정의 해놓음.

        //2. ArrayList 데이터 변경
        arrayList.set(1, 50);

        System.out.println(arrayList);

        //3. ArrayList 데이터 삭제
        arrayList.remove(2);

        System.out.println(arrayList);

        //4. ArrayList 크기 확인하는 방법
        System.out.println(arrayList.size());

        // +) ArrayList.add(인덱스 번호, 데이터값) => 원하는 인덱스 값에 지정하는 방법
        arrayList.add(1, 123);
        System.out.println(arrayList);

        // +) 특정 요소 접근방법
        System.out.println(arrayList.get(1));

        //        정적      vs      동적
        //크기  : 고정              자동 조절
        //타입  : 기본타입만 가능     참조타입만 가능
        //속도  : 빠름              상대적으로 느림
        //유연성: 낮음               높음
        //기능  : 저장 + 조회        저장, 수정, 삭제, 삽입 등에 사용 ㄱㄴ

    }
}
