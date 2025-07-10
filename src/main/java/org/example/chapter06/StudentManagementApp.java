package org.example.chapter06;
import java.util.ArrayList;
import java.util.Scanner;

// 학생 관리 시스템


// 1. 학생 클래스 정의: 학생 정보 저장, 관련 메서드 제공
class Student {
    // 1) 필드 선언
    int studentId;
    String name;
    int age;
    String major;
    double gpa; // 평균 학점

    // 2) 메서드 정의

    void printStudentInfo() {
        System.out.println("ID " + studentId
            + ", Name " + name
            + ", Age " + age
            + ", major " + major
            + ", gpa " + gpa
        );
    }

    void updateGpa (double newGpa) {
        this.gpa = newGpa;
    }

    //3) 생성자 정의
    Student () {
        //필드값 초기화
        this.studentId = 0;
        this.name = "unknown";
        this.age = 20;
        this.major = "Undeclared";
        this.gpa = 0.0;
    }

    // 오버로딩
    Student(int studentId, String name, int age, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }

    Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }
}


//2. 학생 관리 시스템 클래스 정의
// : 메인클래스가 될거임. 학생 등록, 조회, 수정 기능 담당
public class StudentManagementApp {

    // Java 클래스명 = 파일명과 동일(대소문자까지 똑같아야함 //
    // : 하나의 파일에서 public 단위의 클래스는 한 개만 지정 가능함
    //   >> public class 클래스명 = 파일명과 일치함

    //static -> 인스턴스화 없이 클래스 자체에서 호출이 됨
    //       - 메인 메서드 내부에서 다른 메서드 호출 시  반드시 해당 메서드는 static 이어야함

    static ArrayList<Student> students = new ArrayList<>();

    // 학생 등록
    static void addStudent(int id, String name, int age, String major, double gpa) {
        Student student = new Student(id, name, age, major, gpa);
        students.add(student);
        System.out.println(name + "학생이 등록되었습니다");
    }


    // 학생 조회(모든 학생 전체 조회)
    static void printAllStudents() {
        System.out.println("== 전체 학생 목록 ==");
        // for(순회하는 요소의 변수선언: 배열 리스트)

        for (Student students: students) {
            students.printStudentInfo();
        }

    }
    // 학생 검색 -> 학생 아이디를 통해 해당 학생의 정보 출력
    static void findStudentById(int studentId) {
        for (Student student : students) {
            if (student.studentId == studentId) {
                student.printStudentInfo();
                return; //메서드 종료!
            }
        }

        System.out.println(studentId + " 해당 ID의 학생 조회 불가능");
    }

    // 평균학점 업데이트 기능 -> 학생 아이디를 통해 해당학생의 학점 업데이트
    static void updateStudentGpa(int studentId, double newGpa) {
        for (Student student: students) {
            if (student.studentId == studentId) {
                student.updateGpa(newGpa);
                System.out.println("평점이 변경되었습니다.");
                return;
            }
        }
        System.out.println(studentId + " 해당 ID의 학생을 찾을 수 없음");
    }

    //메인메서드: 프로그램 진입점을 제공 반드시 아래 형식이어야만 실행 가능
    // >> JVM은 main 메서드가 없을 경우 해당 파일 자체를 실행 못함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Student student1 = new Student();
//        Student student2 = new Student();
//        Student student3 = new Student();
//        Student student4 = new Student();

        //학생추가
        addStudent(1, "김보민", 20, "IoT", 3.8);
        addStudent(2, "박진영", 21, "IoT", 3.9);
        addStudent(3, "오신혁", 22, "IoT", 3.7);
        addStudent(4, "김세훈", 23, "IoT", 3.8);

        //학생 전체 조회
        printAllStudents();

        //특정학생 조회
        System.out.println("== 특정 학생조회 ==");
        findStudentById(1);
        findStudentById(3);

        //학생 평점 업데이트
        updateStudentGpa(2, 4.1);
        updateStudentGpa(4, 4.5);

        printAllStudents();

        findStudentById(6);

    }

}
