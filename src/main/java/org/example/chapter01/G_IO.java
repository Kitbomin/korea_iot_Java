package org.example.chapter01;

import java.util.Scanner;

public class G_IO {
    public static void main(String[] args) {
        // === 자바의 기본 입출력 (input/output) === //
        // 입력 : 콘솔창을 통해 개발자로부터 입력을 받는 것
        // 출력 : 콘솔창으로 데이터를 출력하는 것

        // 1. 출력
        //System.out.println(출력하고자 하는 변수 또는 상수 또는 데이터 값);

        System.out.println("안녕하셔요"); //ln = 주어진 값을 콘솔에 출력하고 줄을 바꿈 \n
        System.out.print("두번째 수업이와요");
        System.out.println(20250702);
        System.out.print("자바의 입출력");

        // 2. 입력
        // 자바 내장 기능 Scanner 객체를 사용하여 콘솔창에서 입력값을 받음
        // => 다양한 입력 소스로부터 데이터를 읽어올 수 있는 형태
        // System.in => 콘솔 입력창에서 표준 입력을 받는다.

        // 자바의 입력 방법 //
        // 자바의 유용한 도구가 담긴 라이브러리 내에서 Scanner 기능을 가져오기(import)

        /*
        - 스캐너 생성 => Scanner 변수명 = new Scanner (System.in);

        - 우항
        => new Scanner(입력받을 방법);
        => System.in : 현재 실행되고있는 프로그램 IDE 의 콘솔에서 받아옴

        - 좌항
        => Scanner 타입 변수명
        => Scanner은 프린트기라는 대표 명사


         */

//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//
//        System.out.println(a);

        Scanner iotScanner = new Scanner(System.in);
        //2) 스캐너 실행
        // - 스캐너명.next(); => 입력 내용을 문자열로 변환 개행문자는 인식하지 않음.
        // - 스캐너명.nextLine(); => 입력 후의 엔터까지 전체 라인을 문자열로 반환
        // +) 스캐너명.next데이터타입(); => 각 타입의 데이터 입력받기 가능

//        System.out.println("나이 입력 >> ");
//        int age = iotScanner.nextInt();
//
//        System.out.println("키 입력 >> ");
//        int height = iotScanner.nextInt();
//
//        System.out.println("이름을 입력해주세요.");
//        String name = iotScanner.nextLine();
//
//        System.out.println("나이는 " + age);
//        System.out.println("키는 " + height);
//        System.out.println("이름은 " + name);
        
        /* 개행문자 Enter => 줄을 바꿀 때 사용되는 특수 문자
        1) nextInt(), nextDouble() => 숫자만 가져감
         next + DataType  ==> 해당 데이터만 인식
        2) nextLine() 은 줄 전체를 가져감 ==> 키 입력시 실제 Scanner 내부에는 키값 + 개행문자가 저장
         nextInt()에서 키값만 가져가고 개행 문자는 그대로 버퍼에 남김
         nextLine()은 사용자의 입력값을 기다리지 않고 빈 문자열(개행문자)를 담고 종료시킴
         --- 문제상황 ---
         */

        System.out.println("나이 입력 >> ");
        int age = iotScanner.nextInt();

        System.out.println("키 입력 >> ");
        int height = iotScanner.nextInt();

        //여기서 개행문자 처리를 할거임//
        iotScanner.nextLine(); // -> 버퍼처리함 nextInt 후에 남아있는 개행문자를 처리시킴.

        System.out.println("이름을 입력해주세요.");
        String name = iotScanner.nextLine();

        System.out.println("나이는 " + age);
        System.out.println("키는 " + height);
        System.out.println("이름은 " + name);


        // === 스캐너 종료 === //
        // 스캐너 사용 후 메모리 최적화를 위해 스캐너를 종료시켜야함.
        // 스캐너명.close();

        iotScanner.close();

        //스캐너 종류 이후 호출 시 오류 발생 왜냐면 자바는 위에서 차례로 읽거등
        //스캐너 종류 후에는 호출해도 접근 오류가 발생 => 이미 반납한걸 다시 쓸 수는 없으니까

    }
}
