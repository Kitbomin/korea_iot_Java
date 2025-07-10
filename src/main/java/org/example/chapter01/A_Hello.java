package org.example.chapter01;

// ===자바 실행 단계=== //
// 1. 자바 소스 파일(.java) : 고급언어 => 사람이 이해할 수 있는 언어
// 2. javac(자바 컴파일러): 고급 => 저급언어로 바꿔주는 번역기
// 3. 바이트 코드 파일 (.class): 바이트 코드(javac 컴파일러가 번환한 저급언어 저장)가 저장되는 위치
// 4. java 실행: JVM이 기계어로 번역 후 실행

// .java와 .classes 차이

public class A_Hello {
    //메인 메서드 선언 => 프로그램 실행 시 "진입점". 실행 단축 (shift + f10)
    //JVM이 main 메서드를 찾아서 실행하게 됨

    public static void main(String[] args) {
        System.out.println("Hello Java"); //문자열을 출력할 수 있는 도구
    }
}
