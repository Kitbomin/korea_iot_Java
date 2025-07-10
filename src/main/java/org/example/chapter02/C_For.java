package org.example.chapter02;

// == 반복문 == //
// 특정 조건을 만족할 때 까지 동일한 작업을 반복 실행
// for, while, do while


public class C_For {
    public static void main(String[] args) {
        /*
            for문
            -> 특정 조건이 만족 될 때 까지 코드 블록을 반복 실행
            >> 횟수 지정 가능, 반복해야할 횟수가 있을 때 자주 쓰임

            for (초기화식; 조건; 증감식) {
                조건이 만족될 때 까지 실행할 코드 블록
            }

            1. 초기화식
                : 반복을 시작할 때 사용할 변수를 초기화(반복에 사용할 변수)
            2. 조건식
                : 반복이 실행될 조건을 정의하는 부분(해당 조건식이 참인 동안 반복문이 실행)
            3. 증감식
                : 반복문의 각 실행이 끝나고 변수의 값을 증감하는 부분(매 반복 시 실행)

         */

        for (int num = 1; num <= 5; num++) {
            System.out.print(num);
        }

        System.out.println();

        //예제
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i);
            }
        }
        System.out.println();

        //예제 2
        // 구구단(3) 출력
        int num = 3;

        for (int j = 1; j < 10; j++) {
            int result = num * j;
            System.out.printf("%d x %d = %d \n", num, j, result);
        }

        //for문의 횟수 지정 방법

        //1. 초기화를 0으로 설정
        // >> int i = 0; i < N; i++  => N번 반복하게 됨

        //2. 초기화를 1로 설정
        // >> int i = 1; i <= N; i++ => N번 반복하게 됨


        // 중첩 for문 for문 안에 또 for문 작성

        // 예제
        // 구구단 전체 출력 2~9

        for (int i = 0; i < 8; i ++) {
            int dan = i + 2;
            System.out.printf("[%d 단 입니다.] \n", dan);

            for (int j = 0; j <9; j++){
                int number = j + 1;
                int result = dan * number;
                System.out.printf("%d x %d = %d \n", dan, number, result);
            }
        }




    }
}
