package org.example.chapter01;

import java.math.BigDecimal;

public class E_DataType {
    public static void main(String[] args) {
        /*
         데이터 타입(자료형, DataType)
         - 자바 = 강타입 언어. 모든 변수 선언 시 반드시 데이터 타입 명시
            1. 데이터타입 종류

            1) 기본형
            => 변수 선언 시 해당되는 자료형 크기 만큼의 메모리가 할당
            => 실제 데이터가 저장됨

            2) 참조형
            => 객체의 참조(메모리 주소)를 저장하는 변수 타입
            => 객체, 배열과 같이 메모리의 힙 영역에 저장된 데이터의 주소를 참조
            => 실제 데이터가 들어있는 메모리 주소값을 불러옴

            stack => 기본타입의 데이터가 실제 저장되고 참조타입의 주소값이 저장되는 공간
            heap => 참조타입의 실제 데이터가 저장되는 공간
        */

        //1. 기본타입 (자료형 8개)
        // byte(1), short(2), long(8), float(4),
        //  * int(4), double(8), char(2), boolean(1) *


        // 자료형 크기 단위
        /*
        1 byte 체계 == 8 bit ==
        1 bit 는 메모리 한칸 차지

        1-1) 정수형 byte(1) < short(2) < int(4) < long(8)
        byte: -128 ~ +127 까지의 수 저장 가능
        short: -32768 ~ +32767
        int: 약 -2.1억~ 2.1억
        long: 약 - (2^63) ~ +2^63
         */

        byte byteValue = 127;
        short shortValue = 32767;
        int intValue = 287239874;
        long longValue = 123123123123L; //long 타입은 숫자 뒤에 알파벳 L, l 을 써서 표기(대문자 권장)

        /*
        1-2) 문자형 char(Character)
        크기:  2바이트, 단일 문자만 저장 가능
        반드시 '' <- 로 표기

         */
        char grade = 'A';

        /*

        1-3) 실수형 float(4) < double(8)
        부동 소수점이 있는 수 = 실수
        float은 데이터 값 뒤에 알파벳 f 사용

        실수형의 정밀도(유효소수 자릿수)
        1) float은 약 7자리 정도까지 정확하게 표현됨
        float f1 = 123.456789f; => 소수점자리 반올림됨

        2) double은 약 15~16자리까지 정확하게 표현
        double d1 = 123.4567890123456789; => 반올림 됨

        물론 얘네들도 정수 포함임

        금융 계산, 정밀한 수치 연산에서는 BigDecimal <- 이란 자료형을 쓰자 을 사용 권장
        => 그냥 일단 큰 자료형으로 잡아라...

         */

        float dollar1 = 32.123f;
        double dollar2 = 32.123; // 실무에선 이게 더 많이 쓰임
        float f1 = 123.456789f;
        double d1 = 123.4567890123456789;
        System.out.println(d1);

        BigDecimal bigDecimal = new BigDecimal("1234567890.12345678901234567890");
        //문자열로 처리하면 정밀도가 더 올라감
        System.out.println(bigDecimal);

        /*
        1-4) 논리형 boolean
        데이터 값으로 ture, false만 가짐

        1바이트 타입, 데이터 지정 시 소문자 값 사용을 권장함
        => 변수명 지정 시 의문문 사용을 권장

         */
         boolean isMarried = true;
         boolean isActive = true;
         boolean hasSnack = false;

         boolean isLogin = true;
         boolean isLightOn = false;
        /*
        2) 참조 자료형
        기본 자료형을 기초로 만들어진 자료형
        실제 데이터값이 저장되는 것이 아닌 실제 데이터가 저장된 주소 값을 가지는 자료형

        2-1) 문자열 String
        문자열(여러개)를 저장하는데 사용
        반드시 "" 를 사용해 문자열 사용
         */

        String welcomeMassage = "만나서 반갑습니다 :)";
        System.out.println(welcomeMassage);

         // == 데이터 타입 정리 == //
        /*
            정수 : byte < short < int(Integer) < long
            실수 : float < double
            문자 : char(Character)
            논리 : boolean

            괄호안친 애들은 머릿글을 대문자로 바꾸면 그 자체로 참조자료형으로 만들 수 있음(wrapper 클래스)
            wrapper 클래스: 기본 자료형을 객체로 감싸기 위해 제공되는 클래스
                => 기본 자료형을 참조 자료형 처럼 사용하기 위함

            참조 자료형 => 문자열(String), 배열, 객체 ...
         */


        //실습
        // 학생 이름, 학생 나이, 학생 키, 학생 성별, 학생 여부를 변수 선언과 본인의 데이터로 초기화

        String Student_Name = "김보민";
        int Student_age = 23;
        float Student_height = 158.7f;
        char Student_gender = 'F';
        boolean isStudent = true;

        //String Student_Name = "송민수"; => 하나의 영역{} 내에서는 동일한 변수명 사용 불가

        //System.out.printf("");


    }
}
