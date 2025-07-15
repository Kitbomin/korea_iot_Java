package org.example.chapter13;

import java.util.Scanner;

/**
 * === 싱글톤(Singleton) 패턴 ===
 * : 소프트웨어 설게 패턴 중 하나
 * - 클래스의 인스턴스가 하나만 생성되도록 보장
 * - 해당 클래스의 인스턴스에 전역적으로 접근이 가능하도록 하는 패턴
 *
 * 1) 싱글톤 패턴의 특징
 * - 클래스의 인스턴스가 단 하나만 존재
 * - 인스턴스에 대해 전역 접근을 제공
 * - 주로 설정 정보 관리 객체, 공유 자원 관리 객체, 로그 객체 등에서 사용됨
 *
 * 2) 사용 목적
 * - 객체의 유일성을 보장
 * - 자원의 절약을 담당
 *
 * 3) 장단점
 * - 장점
 *    : 중복 인스턴스 방지(메모리 절약)
 *    : 글로벌 상태 유지
 *    : 일관된 상태 유지 처리
 *
 * - 단점
 *    : 결합도가 증가
 *          -> 여러 클래스가 같은 인스턴스 공유 시 하나가 변경 될 때 다른 곳에 영향을 미칠 수 있음
 *    : 테스트에 어려움이 생김
 *          -> 전역상태를 사용하는 특성때문
 *
 * 4) 구현 방법
 */

class Singleton {
    // 필드 값을 static 으로 구현 -> 인스턴스화 없이 호출이 가능, 자원이 하나의 값을 가질 수 있음
    private static Singleton instance;

    // 생성자: private
    // >> 외부에서 직접적인 인스턴스화를 불가능하게 만듬
    // >> 반드시 해당 클래스 내에서만 인스턴스화 시킬 수 있게끔.
    private Singleton() {};


    // 싱글톤 패턴의 전역 접근성을 제공하는 메서드 정의(인스턴스화 담당)
    public static Singleton getInstance() {

        // 주로 getInstance 메서드 명을 사용함
        // : 반환 타입은 클래스 타입
        if (instance == null) {
            //필드에 초기화 이전 >> 아직 인스턴스화 안됨
            instance = new Singleton();
        }
        // 주소값 그대로 반환
        return instance;

        // 1) if 조건문이 true -> 인스턴스화된 객체를 반환
        // 2) if 조건문이 false -> 기존의 필드에 저장된 객체를 반환
        // ==> 이렇든 저렇든 객체는 반드시 하나만 반환됨
    }
}

// == 교장선생님 클래스 == //
// : 학교에 교장은 하나만 존재해야함
class SchoolPrincipal {
    // 유일한 객체를 저장할 변수 : 클래스 그 자체의 객체값을 저장함
    private static SchoolPrincipal instance;

    // 1. 생성자를 private 설정 (외부에서 객체 생성 불가하게)
    // - 생성자는 반환타입이 없지, 접근 제한자는 가능 -> 이름은 클래스명과 동일
    private SchoolPrincipal() {
        System.out.println("교장 선생님 객체 생성");
    }

    // 2. getInstance() 메서드를 통해 객체 생성
    //    : 해당 클래스로 생성된 객체가 없는 경우에만 새롭게 생성해 반환
    public static SchoolPrincipal getInstance() {
        if (instance == null) {
            // 객체가 없다면 새로 생성
            instance = new SchoolPrincipal();
        }
        //객체가 있다면 반환
        return instance;
        // 기존 객체 (if가 false) || 생성 객체 반환(if가 true)
    }

    public void announce() {
        System.out.println("공부 열심히 하고 운동도... 일찍 자고... 일찍 일어나...");
    }
}

class Example {

}


public class D_Singleton {
    public static void main(String[] args) {

        // instance == null => true : 객체가 새로 생성됨
        SchoolPrincipal principal1 = SchoolPrincipal.getInstance();

        // 여기서 부터는 두번째 객체니까 기존 instance의 주소를 반환하게 됨
        SchoolPrincipal principal2 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal3 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal4 = SchoolPrincipal.getInstance();

        System.out.println(principal1);
        System.out.println(principal2);
        System.out.println(principal3);
        System.out.println(principal4);
        // 주소값이 다 같게 출력됨 : org.example.chapter13.SchoolPrincipal@28a418fc

        Example example1 = new Example();
        Example example2 = new Example();
        Example example3 = new Example();
        Example example4 = new Example();

        System.out.println(example1);
        System.out.println(example2);
        System.out.println(example3);
        System.out.println(example4);
        // 얘네들은 다 다른 주소값이 반환됨

        System.out.println(principal1 == principal2); // true값 나옴

        principal1.announce();
        principal2.announce();
    }
}
