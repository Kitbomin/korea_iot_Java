package org.example.chapter07;

// == 캡슐화 == //
// : OOP에서 데이터와 해당 데이터를 처리하는 함수(메서드)를 하나로 묶는 것을 의미
//   - 객체 내부의 구현을 숨기고, 외부에서는 제공된 메서드를 통해서만 접근하도록 설정
//   - 데이터 보호, 유지보수성 향상, 사용자 편의성 증대 등의 역할을 담당

// == getter & setter 메서드 == //
// : 캡슐화 된 데이터에 안전하게 접근하고 수정할 수 있도록 하는 기능
//   +) 데이터의 무결성 유지와 정보 은닉을 담당함
//   => 데이터보호/유지보수성 향상을 목적으로 데이터 필드(속성)을 private 선언
//      >> 데이터에 접근하거나 수정할 때는 getter, setter 메서드를 사용하는 체계를 갖출거임

// 1) getter: 객체의 특정 필드값을 읽는 메서드
//    - get<필드명>();
//      => getName(); , getAge();, getStudentId(); ...

// 2) setter: 객체의 특정 필드값을 설정하는 메서드
//    - set<필드명>();
//      => setName(); , setAge();, setStudentId(); ...

// == 학생 정보관리 클래스 == //
class Student {
    //1. 필드는 private 설정
    private String name;
    private int residentNum;
    private int age;
    private int score;

    // getter: private 필드값을 읽어 반환해줌

    public String getName(){
        return name;
    }

    public int getResidentNum () {
        return residentNum;
    }


    //getter는 단순한 데이터의 반환 뿐만 아니라 데이터 가공역할을 담당하기도 함
    public String getAge() {
        if (age > 19) {
            return "성인";
        } else {
            return "미자";
        }

    }

    public int getScore() {
        return score;
    }

    // setter: 데이터를 받아 내부의 필드에 저장(필드타입의 매개변수와 반환타입이 없음)
    public void setName(String name) {
        this.name = name;
    }

    public void setResidentNum(int residentNum) {
        this.residentNum = residentNum;
    }


    //setter도 가공 많이 함 -> 단순한 데이터 설정 뿐만아니라 데이터의 검증 역할을 담당하기도 함
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("유효하지 않은 나이값");
        } else {
            this.age = age;
        }
    }

    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        }else {
            System.out.println("유효하지 않은 점수입니다");
        }
    }

}

public class B_Encapsulation {
    public static void main(String[] args) {
        Student student = new Student();

//      student.name = "me"; => private 설정되있어서 해당 클래스 외에서는 접근 불가능하게 되어있음

        student.setName("김보민");
        student.setAge(-30);
        student.setAge(23);
        student.setResidentNum(123456789); //이러면 주민번호가 수정될 수가 있음 => 그러면 안되잖음 => 그래서 final을 씀
        student.setScore(-190);
        student.setScore(100);


    }
}

// _(언더바) -(하이픈) 의 차이
// a_Hello => 한 단어로 인식 => 가독성을 위한 단어의 구분
// a-Hello => 두 단어로 인식 => 각 단어의 구분
// 서로 인식되는 영역이 다름
