package org.example.chapter07.animalApp;

// == 동물 관리 시스템 == //

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        // == 서비스 계층(실행) 생성 == //
        // : service 객체의 handleAnimal 메서드는 Animal 타입의 객체를 인자로 받음.
        AnimalService service = new AnimalService();

        //동물을 하나의 리스트로 관리 => 리스트 생성
        //: 객체 타입을 저장할 수 있는 ArrayList 생성

        ArrayList<Animal> animals = new ArrayList<>();

        // 동적 배열에 객체를 추가해보기
        // : Animal 타입의 Cat/Dog 객체 추가해보기

        animals.add(new Cat()); // => 객체 생성과 동시에 업캐스팅 되고 있는거임(자동타입 변환)
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cat());

        //배열의 모든 동물을 service에 전달해 출력해보기
        for (Animal animal: animals) {
            if(animal instanceof Cat) {
                System.out.println("고양이가 있다");
                Cat cat = (Cat) animal; // => 다운캐스팅 -> 자식 클래스가 고유 메서드에 접근가능
                cat.eat();
            }
            service.handleAnimal(animal);
        }

        //객체 생성 및 처리
        Animal cat = new Cat();
        Animal dog = new Dog();

        service.handleAnimal(cat);
        service.handleAnimal(dog);

//        cat.eat(); => 접근 불가

        if (cat instanceof Cat) {
            Cat onlyCat = (Cat) cat;
            onlyCat.eat();
            onlyCat.funactivity();
        }
        
        if (dog instanceof Cat) {
            Cat dogCat = (Cat) dog;
            dogCat.eat();
            System.out.println("강아지는 고양이의 인스턴스가 아니기에 출력이 안됨");
        }
        
        if (dog instanceof Dog) {
            Dog dog1 = (Dog) dog;
            dog1.funactivity();
            System.out.println("강아지는 공놀이를 하고있다");
        }
        
        if (cat instanceof Dog) {
            Cat dogcat = (Cat) dog;
            dogcat.eat();
            System.out.println("출력");
        }
        
        
    }
}
