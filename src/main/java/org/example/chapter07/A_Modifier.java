package org.example.chapter07;

//자바 패키지 또는 클래스 파일 간의 코드 연결
//: import 키워드문을 사용
//  1) 같은 패키지 내 : import 클래스파일 명;
//  2) 다른 패키지 내 : import 패키지경로.패키지명.클래스파일명;

//import org.example.otherpackage.OtherClass;
//import org.example.otherpackage.PublicClass;
import org.example.otherpackage.*;
//전체 가져오기
//다만, 프로그램의 향상성을 위해 권장하지 앟음


//접근제한자 있는 애를 import 해옴

// == 접근제한자(제어자) == //
// : 클래스, 변수, 메서드의 접근 범위를  제어함
//   - 외부로부터 데이터를 보호하고, 객체 간의 의존성을 최소화하는 역할을 함
//   - 코드의 보안성을 향상, 캡슐화를 구현

// 1. 접근 제어자 종류
// : public, (default), protected, private
//   - default => 제어자 생략시 이 값이 자동 지정됨 그렇다고 default를 직접 명시하진 않음
//   - 클래스 자체에 접근 제어자를 사용할 수 없음
//     : 중첩 클래스가 아닌 경우 명시적인 접근제어자가 사용 불가능함
//       >> 클래스 파일의 경우엔 작성이 가능 밑의 public class ~~ 인 경우.

// protected class ProtectedClass {} => 이거 안됨 클래스 자체엔 사용 안됨 만약 이게 메인 클래스 안에 있었다면 가능함



class Modifier {} //default 붙어있음


// 2. 접근 제어자 범위
// public > protected > (default) > private 순의 범위를 가지고 있음

// 1) private : 같은 클래스 내에서만 접근이 가능
class PrivateClass {
    private int myFiled;
    private void myMethod () {
        System.out.println(myFiled); //private 필드는 PrivateClass 내부에서만 사용 가능함
    }
}

// 2) default : 같은 패키지 안이라면 접근 가능 (폴더 단위)
//            - 패키지 외부에서는 접근이 불가능

class DefaultClass {
    int myField;
    void myMethod () {
        System.out.println(myField);
    } //필드와 메서드 앞에 디폴트 생략됨 얘랑 privateClass랑은 다른 애 인거임
}

// 3) protected : 동일한 패키지 내의 모든 클래스에서 접근 가능(default)
//              : 다른 패키지에 있는 경우, 해당 클래스를 상속받은 하위 클래스에서만 접근 가능함

class ProtectedClass extends OtherClass {
    // String otherField;

    ProtectedClass() {
        // >>> OtherClass.java 참고
        // 상속받은 부모 클래스의 필드 & 메서드
        System.out.println(otherField);
        otherMethod();
    }
}

// 4) public : 클래스나 패키지 위치와 상관없이 접근이 가능


public class A_Modifier {
    public static void main(String[] args) {
//      PrivateClass 외부에서 private 필드에 접근
        PrivateClass privateClass = new PrivateClass();
//        privateClass.myFiled;
//        privateClass.myMethod;
        // ------ 접근 안됨 ------- //
        // : 접근 제어자는 가시성을 나타냄 해당 필드가 어디까지 보여질지....
        //   - private는 해당 클래스 내부에서만 접근 가능


        // DefaultClass 외부에서 접근 => 패키지 안이라면 어디든 접근 가능함
        DefaultClass defaultClass = new DefaultClass();
        System.out.println(defaultClass.myField);
        defaultClass.myField = 10;
        defaultClass.myMethod();

        ProtectedClass protectedClass = new ProtectedClass();
//        protectedClass.myField; => A_Modifier 클래스에서 상속받지 않았기에 접근이 불가능함

        //publicClass 사용
        // >>> PublicClass.java 참조 -> OtherClass.java참고
        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField);
        publicClass.publicMethod();

    }
}
