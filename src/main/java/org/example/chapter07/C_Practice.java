package org.example.chapter07;

//접근제어자 확장//
//: protected 접근제어자로 선언된 메서드를 자식 클래스에서 오버라이딩(재정의)
//  >> 접근 제어자 수정이 가능한지 여부를 확인
//  >> 접근 제어자는 같거나 더 넓게만 가능함

import org.example.otherpackage.OtherClass;

class PracticeParent {
    protected void greet() {
        System.out.println("Hello Parent");
    }
}

class PracticeChild extends PracticeParent{
//    @Override
//    protected void greet() {
//
//    }

    // 재정의한 메서드는 부모가 가진 메서드의 범위를 축소 시킬 수 없다
    // -> default랑 private로 줄일 순 없음 => 그럼 public으로는 가능함
    @Override
    public void greet() {
        super.greet();
    }

//   @Override
//   private void greet() {
        //'org.example.chapter07.PracticeChild'의 'greet()'이(가) 'org.example.chapter07.PracticeParent'의 'greet()'와(과) 충돌합니다. 기존의 'protected'보다 약한 액세스 권한('private')을 할당하려고 합니다
        // 접근불가하다는 소리
//       super.greet();
//   }
}

// OtherClass는 내부에 protected 필드와 메서드를 포함하고 있음
public class C_Practice extends OtherClass {
    void exampleMethod () {
        System.out.println(otherField);
        System.out.println(this.otherField);
        otherMethod();
    }

    public static void main(String[] args) {
        OtherClass otherClass = new OtherClass(); //부모클래스으 ㅣ인스턴스
//        otherClass.otherField;
//        otherClass.oterMethod;
        // 객체화를 하고나면 상속과는 무관해짐 protected 접근 제한자의 방해를 받게 됨
        // 반드시 자식클래스 내에서 직접적인 접근만 가능해짐
        // this.필드명(); this생략가능



    }
}
