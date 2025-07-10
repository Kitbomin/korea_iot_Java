package org.example.chapter02;

import java.util.Scanner;

public class B_Switch {
    public static void main(String[] args) {
        //switch?
        // 특정 변수의 값에 따라 실행할 코드 블록의 범위를 결정하는 조건문
        // 비교할 변수와 case 값을 비교해 같은 값일 경우 해당 블록부터 끝까지 실행
        // +) break 키워드에서 스위치문 종료

        /*
            switch (조건 변수) {
                case 조건값1:
                    실행문장;

                case 조건값2:
                    실행문장;

                case 조건값3:
                    실행문장;
                ....

                default:
                    case 조건식이 끝난 뒤 작성
                    >> 어느 case에도 일치하지 않을 경우 실행

            }

            >> full-through 상태: case 영역 내에서 break 키워드 없이 끝까지 실행되는 경우
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("Chapter를 선택하세요 :)");

        int chapter = sc.nextInt();

        switch (chapter) {
            case 1:
                System.out.println("자바 기본문법");
                break; //해당 케이스의 실행이 끝나면 스위치문을 빠져나옴

            case 2:
                System.out.println("자바 제어문 - 조건/반복문");
                break;

            case 3:
                System.out.println("자바 배열");
                break;

            default:
                System.out.println("유효한 chapter가 아닙니다");
        }

        sc.nextLine(); //개행문자 정리

        System.out.println("과일의 이름을 입력해주세요");
        String fruit = sc.nextLine();

        switch (fruit){
            case "banana":
                System.out.println("yellow");
                break;

            case"apple":
                System.out.println("red");
                break;

            case "grape":
                System.out.println("purple");
                break;

            default:
                System.out.println("유효한 타입이 아닙니다");
        }

        sc.close();


        // if와 switch
        // 1. if => 사용 대상은 범위조건, 불리언 참거짓 값으로 분기| 복잡한 조건, 논리식 사용 가능.
        // 사용처 -> 점수판단, 나이 판단, 범위 체크
        // >> 조건이 다양하거나 논리식이 필요할 때 사용
        int score = 80;

        if (score >= 90) {
            System.out.println("우수");
        } else if (score >= 70) {
            System.out.println("평균");
        } else {
            System.out.println("노력필요");
        }


        // 2. switch => 사용 대상은 정해진 값. |조건의 개수는 하나의 변수만 다수의 값과 비교 가능.
        // 사용처 -> 메뉴선택, 문자열 선택
        // >> 정확히 일치하는 값을 비교할 경우 사용

        String grade = "B";
        switch (grade) {
            case "A":
            case "B":
                System.out.println("우수");
                break;

            case "C":
            case "D":
                System.out.println("평균");
                break;

            default:
                System.out.println("노력필요");
        }


    }
}
