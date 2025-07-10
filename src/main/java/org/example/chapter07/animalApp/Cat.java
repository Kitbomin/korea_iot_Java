package org.example.chapter07.animalApp;

public class Cat extends Animal{
    @Override
    void speak() {
        System.out.println("야옹");
    }

    @Override
    void funactivity() {
        System.out.println("낚시 장난감으로 놉니다");
    }

    void eat() {
        System.out.println("츄르");
    }

}
