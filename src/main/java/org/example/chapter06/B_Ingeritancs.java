package org.example.chapter06;

//==상속==//
//: 한 클래스의 속성과 메서드를 다른 메서드가 물려받는것
// - 기존의 클래스를 재사용해 새로운 클래스를 작성하는 것
// = 코드의 재사용성, 중복제거(프로그램의 생산성 증가)

//상속 구현 방법
//: extends (확장하다) 키워드 사용해 구현
//: class 자식클래스 extends 부모클래스 {}


class Parent {} //부모클래스(기존)

class Child extends Parent {} //자식클래스(새로운클래스)

// 명칭
// - 상속해주는 클래스(Parents): 조상, 부모, 상위,기반, 슈퍼클래스
// - 상속받는 클래스(Child): 자손, 자식, 하위, 파생, 서브클래스

// == 동물 클래스 == //
class Animal {
    String name;

}

class Dog extends Animal{
    //String name; //=>  부모 클래스의 속성과 메서드를 모두 상속받은 클래스

    // 클래스의 확장
    // : 부모가 가지지 않은 필드나 메서드 정의 가능
    void bark() {
        System.out.println("멍멍");
    }

}

// Tv 클래스 //
class TV {
    //속성
    boolean power;
    int channel;


    //행위 메서드
    void setPower() {
        //전원 설정
        power = !power;

    }

    void setChannelUp () {++channel;}
    void setChannelDown () {--channel;}
}

class SmartTv extends TV {
    boolean ott;

    void displayOtt (String platform) {
        if (ott) {
            System.out.println(platform);
        }else {
            System.out.println("오티티연결이 안됨");
        }
    }
}


public class B_Ingeritancs {

    public static void main(String[] args) {

        Dog choco = new Dog();
        choco.name = "초코";

        System.out.println(choco.name);
        choco.bark();

        // TV 객체 생성 //
        TV tv1 = new TV(); //여기서 자동 초기화 됨
        tv1.power=true;
        tv1.setChannelUp();
        tv1.setChannelUp();
        tv1.setChannelUp();
        System.out.println(tv1.channel);

        SmartTv smartTv1 = new SmartTv();
        smartTv1.power = true;
        smartTv1.setChannelDown();
        smartTv1.setChannelDown();
        smartTv1.setChannelDown();
        smartTv1.setChannelDown();
        smartTv1.setChannelUp();

        System.out.println(smartTv1.channel);

        smartTv1.displayOtt("N넷플릭스");

        smartTv1.ott=true;

        smartTv1.displayOtt("디즈니플러스");

        // tv1.ott = true; => 부모는 자식의 기능과 행위를 전달받을 수 없음

    }

}
