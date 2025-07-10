package org.example.test.자바OOP구현문제;

//Animal이라는 부모 클래스를 만든다

import java.util.*;

class Animal {
    //Animal 클래스에는 String name과 void makeSound() 메서드가 있다.
    static String name;
    void makesound() {}
}

//Dog, Cat 클래스는 Animal을 상속하고 makeSound() 메서드를 각각 “멍멍”, “야옹”을 출력하도록 오버라이딩한다

class Dog extends Animal{
    Animal name (String name) {
        this.name = name;
        System.out.println(name);
        return null;
    }
    
    @Override
    void makesound() {
        System.out.println("멍멍");
    }
}
class Cat extends Animal{
    Animal name (String name) {
        this.name = name;
        System.out.println(name);
        return null;
    }
    @Override
    void makesound() {
        System.out.println("야옹");
    }
}

//Main 클래스에서 Animal 배열에 Dog와 Cat 인스턴스를 넣고 반복문으로 모든 동물의 이름과 소리를 출력하라.

public class Q1 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        ArrayList<Animal>animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        
        for (Animal animal: animals) {
            dog.name("강아지");
            dog.makesound();
            cat.name("고양이");
            cat.makesound();
        }

        










    }
}
