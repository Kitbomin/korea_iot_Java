package org.example.chapter11;

/**
 * === 결합도와 응집도 ===
 * <p>
 * +) 모듈: 소프트웨어를 각 기능 별로 나눈 소스 단위
 * <p>
 *       - 모듈화: 하나의 큰 소프트웨어를 분리시키는 과정
 *       <hr>
 *
 *       "좋은 소프트웨어일 수록 모듈의 독립성이 높다"
 *       <p>
 *       >> 모듈의 독립성을 결합도와 응집도의 기준 단계로 측정
 *
 *       <hr>
 *
 * <p>
 *     결합도(낮을 수록 좋음)
 *     : 두개의 클래스나 모듈이 얼마나 강하게 연결되어 있는지 나타냄
 *     >> 모듈과 모듈간의 의존도를 나타냄
 *     <hr>
 *     - 낮은 결합도: 두 모듈이 서로 독립적으로 동작<p>
 *     >>> 프로그램 유지보수에 유리, 새로운 기능을 추가하거나 기존 코드 수정 시 오류 발생 가능성을 낮춰준다.
 *
 *     - 높은 결합도: 두 모듈이 서로 얽혀져 동작
 *
 * </p>
 * <hr>
 * <p>
 *     응집도(높을 수록 좋음)
 *     : 하나의 클래스나 모듈 안에서 관련된 작업들끼리 얼마나 잘 모여있는지를 나타냄
 *     >> 한 모듈 내의 구성 요소들 간의 연관성을 의미
 *     <hr>
 *     - 낮은 응집도: 하나의 클래스가 너무 많은 일을 하거나, 관련 없는 일을 하는 것
 *
 *     - 높은 응집도: 하나의 클래스가 관련된 일들만 하고, 해당 일이 잘 명시되어있는 것
 *     >>> 프로그램에 대한 이해, 유지보수에 용이함
 *
 * </p>
 * <hr>
 * <p>
 *     === 결합도와 응집도의 관계 ===
 *     : 낮은 결합도 + 높은 응집도
 *       >> 각 클래스나 모듈이 독립적으로 동작하며 본인의 역할에 충실해야 함
 *       >> 클래스 간의 의존성을 줄이고, 변경에 강한 구조를 작성
 *
 * </p>
 *
 *
 * */


//1) 낮은 결합도
interface Teacher {
    void teach();
}

class KoreanTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("국어쌤은 국어를 가르쳐요");
    }
}

class MathTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("수학쌤은 수학을 가르쳐요");
    }
}

class ClassRoom {
    private Teacher teacher; //인터페이스 타입으로 선언 -> 리스코프 치환 원칙, 의존역전 원칙


    //의존성 주입 Dependency Injection
    //: 클래스가 직접 객체를 생성하지 않고, 외부에서 객체를 주입을 받도록 설계됨
    //- 객체 간의 강한 결합을 줄이고, 변경에 유연하게 대처 가능
    public ClassRoom(Teacher teacher) {
        this.teacher = teacher;
    }

    public void startClass() {
        teacher.teach();
    }
}

//2) 높은 응집도
class StudentCohesion {
    //학생은 공부의 기능만을 담당

    private String name;
    public StudentCohesion(String name){
        this.name = name;
    }

    public String getName() {return name;}
}

class Attendance {
    // 출석부는 출석 체크 기능만 담당

    public void checkAttendance(Teacher teacher, StudentCohesion studentCohesion){
        System.out.println(studentCohesion.getName() + " 학생이 출석했어용");
        teacher.teach();
    }

}


// 의존성 주입(DI, Dependency Injection)
// : 객체가 필요한 의존 객체를 직접 생성하지 않고, 외부에서 주입 받는 것을 의미
// - 결합도가 낮아짐
// - 테스트가 용이해짐
// - 코드 재사용성이 증가함



// 제어의 역전(IoC, Inversion if Control)
// : 객체의 생성과 관리를 개발자가 아닌 "외부 컨테이너(Spring ...)" 가 담당하게 하는 구조
// - 개발자가 객체를 생성하는 것이 아닌 프레임워크가 대신 처리해주는 것
// >> IoC 컨테이너가 해당 역할을 담당 (현재 예제 없음)
// >> ClassRoom이 직접 객체를 생성하지 않고, 외부에서 주입받는 방식(IoC)



public class D_Coupling_Cohesion {
    public static void main(String[] args) {
        Teacher koreanTeacher = new KoreanTeacher();
        Teacher mathTeacher = new MathTeacher();


        //해당 ClassRoom이 교사 객체를 직접 생성하지 않고, 외부에서 주입됨
        // >> ClassRoom이 어떤 선생님 객체가 들어오든 ClassRoom 안에서 무언갈 수정하거나 할 필요는 없다.
        // 의존성 주입
        ClassRoom koreanClass = new ClassRoom(koreanTeacher);
        ClassRoom mathClass = new ClassRoom(mathTeacher);

        StudentCohesion student = new StudentCohesion("이승아");
        Attendance attendance = new Attendance();
        attendance.checkAttendance(mathTeacher, student);


    }
}
