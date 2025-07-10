package org.example.test.자바OOP구현문제;

//Person 클래스는 name, age 필드를 가진다.

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        System.out.println(name + age);
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
        if (age < 0) {
            System.out.println("유효하지 않아용ㅇ");
        }
    }
}


// 모든 필드는 private으로 선언하고, 각각에 대한 getter와 setter를 작성한다.
// 나이가 0보다 작을 수 없도록 age에 대한 유효성 검사 로직을 setter에 작성한다.
// Main 클래스에서 객체 생성 후 정보 출력.

public class Q2 extends Person{

    public Q2(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {

        Person person1 = new Person("이름이에용", 50);
        Person person2 = new Person("롸롸롸", -20);



    }
}
