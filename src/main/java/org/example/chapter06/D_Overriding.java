package org.example.chapter06;

// 오버라이딩
// : 자식 클래스가 부모 클래스에서 상속받은 '메서드'를 자신의 상황에 맞게 '재정의' 하는 것
//   - 상속 관계에 있는 클래스 사이에서만 사용됨 
//   - 부모 클래스의 기본 동작을 자식 클래스에서 변경하거나 확장할 때 사용함

class ParentClass {
    void exercise () {
        System.out.println("달리기를 잘 합니다");
    }
}

class ChildClass extends ParentClass{

    @Override
    //: 자바에서 제공하는 코드 어노테이션
    //  > 부모 클래스의 메서드를 자식 클래스에서 재정의 했다는걸 명시적으로 나타냄
    // 생략해도 오류가 안남 => 자바에서 알아서 해석해줌

    void exercise() {
        System.out.println("달리기도 하고 점프를 잘 합니다");
    }
}

// === 오버 라이딩의 특징 === //
//1. 메서드 시그니처가 일치
// : 부모클래스의 메서드와 동일한 이름, 매개변수 구성을 가져야함 
//  +) 반환 타입은 일치하거나 자동 형 변환이 가능해야함 
//2. 메서드 명 바로 위에 @Override 어노테이션 작성해야함
//3. 다형성 구현 
// : 하나의 이름으로 여러 기능을 수행하는 코드 작성
//4. 재사용성과 확장성 향상 
// : 기존의 코드 변경없이, 새로운 기능 추가와 변경이 가능함

class AnimalClass {
    void sound() {
        System.out.println("동물이 울음소리를 냅니다.");
    }
}

class DogClass extends AnimalClass {
    @Override
    void sound() {
        System.out.println("강아지가 멍멍함");
//        super.sound();
    }
}

class CatClass extends AnimalClass {
    // 오버라이딩 단축키: ctrl + o

    @Override
    void sound() {
        System.out.println("고양이가 야옹함");
    }
}

public class D_Overriding {
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        parentClass.exercise();
        ChildClass childClass = new ChildClass();
        childClass.exercise();

        AnimalClass animalClass = new AnimalClass();
        animalClass.sound();

        DogClass dog1 = new DogClass();
        dog1.sound();

        CatClass cat1 = new CatClass();
        cat1.sound();

        // >> 해당 상태나 동작을 반드시 가지지만 상속받는 클래스마다 차이를 두고싶은 경우 - 오버라이딩 활용
        // == 오버로딩 vs 오버라이딩 == //
        /*
            공통점 : 메서드의 이름을 재사용하는 방법 (다형성 - 같은 이름으로 다른 행위를 하는것)

            1) 오버로딩: 같은 클래스 내에서 같은 이름ㅇ르 가진 메서드를 여러개 정의하는 것
               - 메서드명은 동일
                    >> 매개변수의 타입, 개수, 순서 중 적어도 하나 이상은 달라야함
                    >> 반환타입 상관 없음
               - 메서드 동작을 다양한 상황에 맞춰 조정 가능함

            2) 오버라이딩: 상속관계에 있는 클래스에서 사용
               - 메서드 시그니처(반환타입, 이름, 매개변수) 가 동일함
               - 메서드의 동작을 변경하거나 확장 가능함
               +) @Override 어노테이션 사용시 컴파일러의 고생을 좀 덜어줌
         */
    }

}
