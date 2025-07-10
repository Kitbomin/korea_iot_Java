package org.example.chapter02;

import java.util.Scanner;

public class D_While {
    public static void main(String[] args) {
        // == while == //
        // 반복 횟수가 정해져있지 않을 경우에 사용.

        // - 조건을 검사 -> 해당 조건이 true -> 코드 블럭을 (반복적)실행 => if문을 반복한 버전...?
        //if 문의 반복 형태

        /*

            while(조건식) {
                조건이 참일 경우 실행

            }

            >> for 문의 초기화 식과 증감식이 조건문과 분리된 형태
                >> for (초기식; 조건식; 증감식){}
         */

        //for 문으로 1부터 5까지 출력하는 문장 작성
        System.out.println("for문 출력");
        for (int i = 1; i <= 5; i++){ //초기화, 조건, 증감
            System.out.println(i);
        }

        System.out.println("while문 출력");
        //초기화 식은 while 전에 등장
        int i = 1;
        while (i <= 5) { //조건식
            //증감식
            System.out.print(i);
            i++;
        }

        // 홀수만 출력(break, continue)
        //break: 반복문 내에서 해당 키워드를 만나면 반복문을 탈출하게 됨.

        //continue: 반복문 내에서 해당 키워드를 만나면 아래의 코드를 무시하고 다시 '조건 검사'로 돌아감

        System.out.println();
        System.out.println();

        //초기화
        int num = 0;

        //while문 시작
        while (true) { //조건식 | if문과 while문의 조건식은 논리값으로 검증되어야함 => 결과값이 논리형이어야함
            // while 문은 조건식을 true로 고정하는 경우 종료 시점을 개발자가 직접 지정하지 않으면 무한루프에 걸린다...
            // 프로그램의 과부하 방지를 위해 지양함
            if (num % 2 == 0) {
                //짝수
                num++; //다음 수 홀수를 위한 작업
                continue;//조건식으로 다시 돌아감(while의 조건식)
            }

            System.out.println(num);
            num++;

            if (num == 20) break;


        }

        //do while
        // while과의 차이점 => 코드가 반드시 한번은 실행된다는 것이 차이점.

        System.out.println("do while 출력");

        /*
            do {
                실행문
            }
            while (실행문에 대한 조건);

            //while과의 공통점 => 초기화식과 증감식이 분리되어있음

         */

        int doNum = 1;
        do {
            System.out.println(doNum);
            doNum++;

        }while (doNum <= 5);


        int a = 6;
        while (a < 5) {
            System.out.println(a);
        }

        do {
            System.out.println(a);
        }while (a < 5);

        //while VS do-while
        // 1) while => 조건검사 시점은 실행 전 이루어짐. 최소 실행횟수가 보장이 안됨.

        // 2) do-while => 조건 검사 시점이 실행 후 이루어짐. 최소 실행횟수에 대한 보장이 이루어짐.(1번)

        //===예제=== 사용자의 입력을 받아 1부터 10 사이의 숫자가 입력될 때까지 반복//
        // do - while로 작성

        Scanner sc = new Scanner(System.in);

        int b;

        do {
            System.out.println("1부터 10 사이의 숫자를 입력하세용");
            b = sc.nextInt();

        }while (b < 1 || b > 10);

        System.out.println("올바른 숫자: " + b);

        // while 문은 반복 전에 조건을 검사하기에 초기 입력 코드를 반복문 밖에 따로 작성해야함

        System.out.println("1부터 10까지의 숫자를 입력하셔용");

        int inputnum = sc.nextInt();

        while (inputnum > 10 || inputnum < 1){
            System.out.println("다시 입력하세용(1~10)");
            inputnum = sc.nextInt();//코드 중복 발생
        }


        // 사용자의 입력을 받을 땐 do - whlie문이 더 효과적임.

        //
    }
}
