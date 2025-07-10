package org.example.chapter07.animalApp;

//서비스 계층: 공통 부모 타입 Animal을 활용해 동물 객체를 처리

public class AnimalService {
    void handleAnimal(Animal animal) {
        // 다형성을 사용해 공통 메서드를 처리

        animal.speak();
        animal.funactivity();
    }

}
