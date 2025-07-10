package org.example.chapter08;

// === 인터페이스(사람과 사람 사이의 규약) === //
// : 객체가 어떤 방식으로 동작해야 하는지 정의하는 추상타입
// - 객체의 동작을 약속, 규칙

//1. 인터페이스의 구성
// : 추상메스드와 상수로만 구성된 특수한 클래스
// - 모든 메서드는 추상 메서드 public abstract
// - 모든 필드는 상수 public static final의 특성을 가짐
// -- 프로그램 전반의 규칙
//    >> 실제 구현은 인터페이스를 구현한 클래스에서 담당
// -- 필수 키워드 생략 가능함 (부분생략도 가능함) -> 근데 거진 다 생략함

//2. 인터페이스의 특징
// : 다중 구현을 지원 -> 한 클래서에서 여러 인터페이스를 동시에 구현 가능함
// : 객체의 행동을 정의하는 역할을 담당함

//3. 인터페이스 구현방법
// : interface 키워드 사용(인터페이스명은 클래스명 지정과 동일함 - UpperCamelCase)
// - interface 인터페이스명 {}

interface PlayingCard {
    //멤버 => 필드 + 메서드를 같이볼때 쓰는 말
    //1. 필드 (=멤버변수) : 상수선언
    // : public static final 특성을 가짐

    public static final int SPADE = 4;
    public static int DIAMOND = 3;
    public final int HEART = 2;
    int CLOVER = 1;

    //2. 메서드: 추상메서드
    // : public abstract 특성을 가짐

    public abstract String getCardNum();
    String getCardKind();

    // +) 추가메서드

    //3. 디폴트 메서드
    // : 인터페이스에서 새로운 기능을 추가하면서 기존 구현을 포함함
    //   >> 기본 구현이 있는 메서드, 오버라이딩이 가능함
    default void defaultMethod () {
        System.out.println("디폴트 메서드임");
    }

//    void defaultMethod2 () {} => 키워드 가져야함
    // 인터페이스 추상 메서드는 본문을(구현부...?) 가질 수 없음

    //4. 정적 메서드
    // : 인터페이스에서 직접 구현
    //   >> 인터페이스 명으로 직접 호출이 됨(static), 오버라이딩이 불가능
    //   >> 객체인스턴스 없이 사용가능함
    //   >>> 인터페이스와 관련된 공통 동작(유틸리티) 메서드를 제공하기 위해 사용함

    static void staticMethod () {
        System.out.println("정적 메서드임");
    }

}

// 추상 클래스는 확장 (extend) 사용
// 인터페이스 구현
// class 클래스명 implements 인터페이스명 {} ==> 을 사용함


class Card implements PlayingCard {
    //필드값 정의
    private String cardNum;
    private String cardKind;

    Card(String cardNum, String cardKind) {
        this.cardNum = cardNum;
        this.cardKind = cardKind;
    }

    //인터페이스 안의 추상 메서드를 구현한 클래스 메서드는 public 지정이 되어야함

    @Override
    public String getCardNum() {
        return cardNum;
    }

    @Override
    public String getCardKind() {
        return cardKind;
    }

    // 디폴트 메서드 - 재정의 가능
    // 정적 메서드 - 재정의 불가

    @Override
    public void defaultMethod() {
        System.out.println("Card 클래스에서 재정의 된 디폴트 메서드");
    }


    //인터페이스는 추상 메서드 정의를 강제함
}


public class B_Interface {
    public static void main(String[] args) {
        Card card = new Card("7", "HEART");

        System.out.println(card.getCardKind());
        System.out.println(card.getCardNum());

        card.defaultMethod();

//        card.staticMethod => static 메서드는 해당 메서드에 포함된 인터페이스 상에서만 호출이 가능함
        PlayingCard.staticMethod();

        //인터페이스 필드(상수) 사용
        System.out.println(PlayingCard.CLOVER);
        System.out.println(PlayingCard.HEART);
        System.out.println(PlayingCard.DIAMOND);
        System.out.println(PlayingCard.SPADE);
    }
}
