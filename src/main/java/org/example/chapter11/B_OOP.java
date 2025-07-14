package org.example.chapter11;

// 4. ISP : Interface Segregation Principle -> 인터페이스 분리 원칙
//        - 하나의 큰 인터페이스보다 여러개의 작은 인터페이스를 사용하는 걸 권장
//        - 인터페이스의 단일 책임을 강조하는 원칙
//        - 클래스는 자신이 사용하지 않는 메서드에 의존하지 않아야함

// 1) 잘못된 걸계 예제

interface Worker {
    void work();
    void eat();
}
class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("로봇은 일을 할 수 있어요");
    }

    @Override
    public void eat() {
        System.out.println("로봇은 음식을 먹지 않아요");
    }
} // 필요하지 않은 행위를 강제로 구현하는게 비효율적임

// 인터페이스가 SRP도 위반하고, ISP도 위반한 상태임

// 2) 올바른 설계 예제
interface Workable { void work();}
interface Eatable { void eat();}

class Employee implements Workable, Eatable {
    //인터페이스는 다중 구현이 가능하단 점

    @Override
    public void eat() {
        System.out.println("13시 ~ 14시 점심");
    }

    @Override
    public void work() {
        System.out.println("9시 ~ 6시 업무");
    }
}
class RobotClass implements Workable {
    @Override
    public void work() {
        System.out.println("로봇이 일을 해용");
    }
}
// 인터페이스 분리 원칙


// 5. DIP : Dependency Inversion Principle -> 의존 역전 원칙
//        - 고수준 모듈은 저수준 모듈에 의존해선 안된다
//        - 모두 추상화에 의존해야함
//        - 세부 구현이 아닌, 추상화 된 인터페이스에 의존하도록 설계해야함
//          >> 구체적인 클래스를 직접 쓰지 말고, 인터페이스를 사용해 느슨하게 연결해야함 -> 그래야 서로간의 의존성이 높아지지 않음

// 1) 잘못된 설계 예제
class MathBook {
    void read() {
        System.out.println("수학책을 읽어용");
    }
}

class WrongStudent {
    private MathBook book;
    public WrongStudent() {
        this.book = new MathBook();
    }
    void study () {
        book.read();
    }
}// 이러면 여기서 정의된거밖에 못씀 >> 다른 걸로 변경하려면 코드 자체를 수정해야함 -> 유지보수성 하락


// 2) 올바른 설계 예제
interface Book {
    void read();
}

class ScienceBook implements Book{
    @Override
    public void read() {
        System.out.println("과학책을 읽어용");
    }
}
class KoreanBook implements Book {
    @Override
    public void read() {
        System.out.println("국어책을 읽어용");
    }
}

class CorrectStudent {
    private Book book; // 추상화된 인터페이스에 의지 중
    public CorrectStudent(Book book) {
        this.book = book;
    }

    void study(){
        book.read();
    }
}


public class B_OOP {
    public static void main(String[] args) {
        // 과학책으로 공부
        Book scienceBook = new ScienceBook();
        CorrectStudent student1 = new CorrectStudent(scienceBook);
        student1.study();

        // 국어책으로 공부
        Book koreanBook = new KoreanBook();
        CorrectStudent student2 = new CorrectStudent(koreanBook);
        student2.study();

        //이렇게 의존성에서 벗어날 수 있음
    }
}
