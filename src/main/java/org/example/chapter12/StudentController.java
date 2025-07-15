package org.example.chapter12;

import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private final List<Student> studentList;
    private int nextId;

    public StudentController(List<Student> studentList) {
        this.studentList = studentList;
        this.nextId = studentList.size(); //studentList의 사이즈를 확인
    }

    // 학생 추가(Create)
    public void addStudent(StudentRequestDto dto) {
        // 만약 학생 추가 시 입력한 StudentNumber의 학생이 존재하는 경우 -> 기능이 동작하지 않고, 메시지 출력을 하게끔 리팩토링
        StudentResponseDto studentResponseDto = getStudentById(dto.getStudentNumber());
        //검색
        if (studentResponseDto != null) {
            //입력받은 studentNumber의 학생이 존재 - > 학생 추가가 불가능
            System.out.println("해당 학번의 학생이 이미 존재합니다.");
            return;
        }

        //학생 요청 데이터를 객체로 받을 거임
        Student student = new Student(nextId++, dto.getName(), dto.getAge(), dto.getStudentNumber());
        studentList.add(student);

        System.out.println(dto.getName() + " 학생이 추가 되었습니다. 학번: " + dto.getStudentNumber() + "입니다.");
    }

    // 학생 전체 조회
    public List<StudentResponseDto> getAllStudents() {
        List<StudentResponseDto> response = new ArrayList<>();

        //데이터 가공 과정 Student >> StudentResponseDto
        for (Student student: studentList) {
            response.add(new StudentResponseDto
                    (student.getName(),
                    student.getAge(),
                    student.getStudentNumber(),
                    student.getCreatedAt()));
        }
        return response;
    }


    // 학생 단건 조회
    public StudentResponseDto getStudentById(String studentNumber) {
        for (Student student: studentList) {
            if(student.getStudentNumber().equals(studentNumber)) {
                return new StudentResponseDto(
                        student.getName(),
                        student.getAge(),
                        student.getStudentNumber(),
                        student.getCreatedAt()
                ); //조회한 학생이 존재하는 경우(데이터 반환)
            }
        }
        return null; //조회한 학생이 없을 경우 (null 반환)
    }


    // 학생 수정
    public boolean updateStudent (StudentRequestDto dto) {
//        // 수정할 학생이 존재하는 지 확인
//        StudentResponseDto studentResponseDto = getStudentById(dto.getStudentNumber());
//        if (studentResponseDto == null) {
//            //수정할 학생 정보 존재가 존재하지 않으면
//            return false;
//
//        }

        for (Student student: studentList) {
            if(student.getStudentNumber().equals(dto.getStudentNumber())) {
                student.setName(dto.getName());
                student.setAge(dto.getAge());
                return true;
            }
        }return false;
    }


    // 학생 삭제
    public boolean removeStudent (String studentNumber) {
        for (Student student: studentList) {
            if (student.getStudentNumber().equals(studentNumber)) {
                studentList.remove(student);
                return true;
            }
        }return false;
    }
}
