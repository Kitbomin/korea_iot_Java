package org.example.chapter07;

// === 자바의 데이터 타입 === //
// 1) 기본자료형: 변수 자체에 데이터가 저장되는 것
//     - 자료형의 변환
//     - 자동 형 변환, 강제 형 변환


// 2) 참조자료형: 변수에 데이터가 저장된 주소값이 저장
//     - 클래스 타입 형 변환
//     - 자동타입 변환 & 강제타입 변환
//       >> 자료형 변환보다 가능한 범위가 좁음
//       >>> 상속 관계에 있는 클래스 사이에서만 변환이 가능함

class G_Parent {
    void displayInfo() {
        System.out.println("부모 클래스입니다");
    }

}

class G_Child extends G_Parent {
    @Override
    void displayInfo() {
        System.out.println("자식 클래스 입니다.(재정의)");
    }

    void childMethod () {
        System.out.println("자식 클래스만이 가지는 메서드입니당");
    }

}


public class G_Class_Type {

    byte a =1;
    short b = a;
    char c = (char) b; //타입의 체계가 달라도 숫자와 문자의 관계라도 변환이 가능함

    public static void main(String[] args) {
        //1. 자동타입 변환(업케스팅 Upcasting) : 자식 객체를 부모 클래스 타입으로 변환
        //   >> 직접 명시하지 않는 자동 타입 변환이 발생
        // 1) 자식 객체를 생성하면서 즉시 부모타입으로 변환해 저장

        G_Parent childObject = new G_Child(); //자기 자신의 메서드를 행할 수 없음
        childObject.displayInfo();
//      childObject.childMethod(); 'G_Parent'의 메서드 'childMethod'을(를) 해결할 수 없습니다...
        // 자동 형 변환(업캐스팅)의 경우 해당 객체는 보존되면서, 부모 객체처럼 사용됨
        //   >> 두 클래스 간의 공통된 특성이 아니면 자식만의 기능은 사용할 수 없음

        // 2) 이미 생성된 객체를 부모 타입으로 변환
        G_Child childObject2 = new G_Child();
        childObject2.displayInfo();
        childObject2.childMethod();

        // 부모클래스 객체 변수명 = 자식객체변수;
        G_Parent parentObject = childObject2; //업캐스팅
        parentObject.displayInfo();
        // parentObject.childMethod(); => 업캐스팅되서 자식 고유의 행위는 못씀

        //2. 강제 타입 변환(다운캐스팅 down casting)
        //   : 부모 클래스타입으로 변환된 객체를 다시 자식클래스 타입으로 변환하는 것
        //   - 자식클래스에만 정의된 멤버에 다시 접근이 가능해짐! | 업캐스팅되어있는 상태가 전제조건
        //자식타입 객체변수명 = (자식 타입) 부모객체;
        G_Child g_child   = (G_Child) parentObject;
        g_child.displayInfo();
        g_child.childMethod();

        //클래스 타입 변환시 주의점 : 반드시 상속 관계와 객체의 실제 타입을 확인해야함
        // >> 잘못된 캐스팅은 Exception 예외 발생
    }

}
