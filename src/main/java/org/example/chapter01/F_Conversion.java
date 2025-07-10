package org.example.chapter01;

public class F_Conversion {
    public static void main(String[] args) {
        /*
            === 자바의 형 변환 conversion ===

            변수 형 변환 => 하나의 타입을 다른 타입으로 바꾸는 것

            자료형의 크기에 따른 변환 규칙
            표현 가능한 범위 기준에 따른 변환 규칙 => 메모리 크기와 순서가 다를 수 있음

            byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)

            char(2)

            boolean(1)



        */


        //1. 자동(묵시적) 형 변환
        // 작은 자료형 => 큰 자료형으로 변환 (왼쪽 => 오른쪽으로 진행) * 이건 컴파일러가 함

        byte smallBox = 10;
        int bigBox = 10000;

        bigBox = smallBox; //재할당의 역할을 함
        // 변수는 재할당 시 기존의 값이 새로운 값으로 대체(변환)됨.

        System.out.println(bigBox);

        byte a = 30;
        short b = a;
        int c = b;
        long d = c;

        float e = d; // 4바이트 float에 8바이트 long 데이터 삽입 가능

        // char f = e; <- 형변환의 오류가 발생

        System.out.println(e);



        // ------------------------ //

        //2. 강제(명시적) 형 변환
        // 큰 자료형 => 작은 자료형으로 변환 (오른쪽 => 왼쪽으로 진행) * 이건 JVM이 함

        int intNumber = 1234;
        float floatNumber = intNumber;

        //int intNum2 = floatNumber; <- 오류 남
        //강제 형 변환 => 작은 타입 변수명 = (작은타입) 큰 데이터값;
        int intNum2 = (int)floatNumber;

        System.out.println(intNum2);

        long aa = 32L;
        int bb = (int)aa;
        short cc = (short)bb;
        byte dd = (byte)cc;

        System.out.println(dd);

        // ----------------------- //

        //3. 문자 형 변환
        // 유니코드 라는 것을 이해해야함
        // 전 세계의 모든 문자를 하나의 코드값으로 표현하는 국제 표준
        // 유니코드의 등장 전까진 각 나라의 원하고자 하는 코드값을 씀. 영어 -> 아스키, 한국어 -> EUC-KR ...
        // - 웹에서는 주로 UTF-8 이란 유니코드 형식을 사용 / 이모지까지 코드값으로 변환 가능
        // 문자마다 고유한 숫자 코드가 정해져있음. => A 는 '65' ...

        //1) char => 숫자로 변환 -> 문자의 유니코드 값으로 변환한다는 뜻
        char letter = 'A';
        int unicodeLetter = letter;

        System.out.println(unicodeLetter);

        char c1 = 'a';
        char c2 = 97;
        char c3 = '\u0061'; //유니코드 값을 16진수로 변환한거

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        //3가지 다 a를 표현함. char 형에 담기면 유니코드가 단일문자로 변환되어 저장됨

        // ------------------------- //

        //2) 숫자를 문자로 변환

        int numberChar = 66; //4바이트 체계
        char letter66 = (char)numberChar; //2바이트 체계 / 이러면 명시적, 강제 형 변환을 해야함

        System.out.println(letter66);

        //char는 문자지만, 내부적으로는 유니코드로 처리. 문자와 숫자간의 변환은 형 변환 형식을 그대로 사용한다.

        // ---------------------- //

    }
}
