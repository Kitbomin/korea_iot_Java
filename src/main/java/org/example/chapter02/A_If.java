package org.example.chapter02;

// == 제어문 == //
//프로그램의 실행 흐름을 제어하는 문법

// 1) 조건문
// 특정 조건을 만족할 때만 코드 블럭을 실행
// if, else, else if => 조건에 따라 실행할 코드를 결정하게 됨.
// switch, case, default => 여러개의 경우(case) 에 대해 실행할 코드를 결정

// 2) 반복문
// 특정 조건이 만족될 때 까지 코드블록을 반복 실행
// for, while, do while

import java.util.Scanner;

public class A_If {
    public static void main(String[] args) {
        //1. if 문과 else문

        /*
        if문 기본형태

        if (조건식) {
            조건이 참인 경우 실행할 코드
        }
        -----------------------------------

        if (조건식) {
            조건이 참인 경우 실행할 코드
        }

        else {
            조건이 거짓인 경우 실행할 코드
        }

        => 조건식은 한개

        --------------------------------

        else if (조건식) {
            앞선 조건식이 거짓이면, 해당 조건식이 참인 경우에 실행할 코드
        }

        >> if와 else 사이에 쓰임. else가 필수인건 아님.
        >> 또한 수의 제한이 없다. if와 else문 사이 몇개든 넣을 수 있음.
         */

        //예제1 나이분류
        int age = 14;

        if (age > 19) {
            System.out.println("성인 입니다");
        } else {
            System.out.println("미자입니다");
        }

        // 예제 2 나이분류 (else if)

        if (age > 19) {
            System.out.println("성인입니다.");
        } else if (age > 13) {
            System.out.println("청소년입니다.");
        } else {
            System.out.println("어린이입니다.");
        }

        // 예제 3 나이분류 (중괄호 생략) => 조건문에서 실행될 코드블럭{}에 코드가 하나의 구문인 경우 {} 생략 가능

        if (age > 19) System.out.println("성인");
        else if (age > 13) System.out.println("청소년");
        else System.out.println("어린이");


        // 코드 컨벤션 //

        //1. 중괄호 내부는 한칸씩 들여쓰기
        //2. 기호와 키워드 사이에는 한칸 띄어쓰기
        //3. 콜론의 경우 'A: B'가 기본

        // 예제 if //


        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();

            // == 풀이 == //
        String functionScope = null; // 스트링과 같은 참조 자료형은 기본값은 null로 표시

        if (x > 0 && y > 0) {
            functionScope = "1사분면";
//            System.out.println(functionScope);
        } else if (x < 0 && y > 0) {
            functionScope = "2사분면";
//            System.out.println(functionScope);
        } else if (x < 0 && y < 0) {
            functionScope = "3사분면";
//            System.out.println(functionScope);
        } else if (x > 0 && y < 0) {
            functionScope = "4사분면";
//            System.out.println(functionScope);
        } else {
            System.out.println("원점입니다");
        }
        System.out.println(functionScope);
        sc.close();
    }
}
