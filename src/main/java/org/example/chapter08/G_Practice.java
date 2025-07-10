package org.example.chapter08;

// === 인터페이스 === //
// : Fruit 과일 인터페이스 정의
// - color: 추상메서드
// - describe: 디폴트 메서드
// - printType: 정적 메서드

interface Fruit {
    //추상
    String color();

    //디폴트
    default void describe() {
        System.out.println("과일의 색상은 " + color() + "이고 모양은 동그랗습니당ㅇ");
    }

    //정적
    static void printType() {
        System.out.println("과일(Fruit) 타입입니다");
    }
}

class Apple implements Fruit {
    public String color() { return "red"; }

}

class Orange implements Fruit {
    public String color(){ return "orange"; }
}

class Banana implements Fruit {
    public String color() {return "yellow"; }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 모양은 깁니당");
    }
}

// 인터페이스 간의 상속 //
// extends는 클래스간, 인터페이스 간의 확장이 가능함
// implements 는 인터페이스를 클래스에 사용할 때 가능
interface TropicalFruit extends Fruit {
    // [생략] -> color, describe, printType이 생략되어있음 (있긴 있음 표기가 안되어 있을 뿐)

    default void tropicalFeature() {
        System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
    }
}

class Mango implements TropicalFruit {
    @Override
    public String color() {
        return "yellow";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + " 이며, 모양은 타원형입니당");
    }

}


public class G_Practice {
    public static void main(String[] args) {
        //다형성 적용
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        Fruit banana = new Banana();
        TropicalFruit mango = new Mango();

        apple.color();

        //업캐스팅
        //: mango를 Fruit 타입으로 형 변환 시킬거임
        //  > Tropical... 이 Fruit를 상속받는 인터페이스 이기 때문
        Fruit[] fruits = {apple, orange, banana, mango };

        for (Fruit fruit: fruits) {
            fruit.describe();
//            fruit.tropicalFeature(); => 얘는 그... 다운캐스팅 해야함

            if (fruit instanceof TropicalFruit) {
                TropicalFruit tropicalFruit = (TropicalFruit) fruit;
                tropicalFruit.tropicalFeature();
            }
        }
        
        // A instanceof B => A객체가 B클래스(종류)와 같은지 확인하는거임
        class Animal {}
        class Cat extends Animal{}
        class Dog extends Animal{}
        
        Animal animal = new Animal();
        Animal nabi = new Cat();
        Animal choco = new Dog();
        
        if (animal instanceof Cat) {
            System.out.println("실행되지 않음. 부모객체는 자식 객체에 담을 수 없음ㅁ");
        }
        if (nabi instanceof Animal) {
            System.out.println("실행됨. 나비는 동물의 일부");
        }
        if (nabi instanceof Cat) {
            System.out.println("나비는 고양이니까 실행됨. 고양이만이 가진 특정 기능을 수행하길 원함");
            Cat meow = (Cat) nabi; //조건문 외부에서도 정상 작동하지만 좀 더 안전하게 실행하고자 조건문 안에 넣음
        }

    }
}
