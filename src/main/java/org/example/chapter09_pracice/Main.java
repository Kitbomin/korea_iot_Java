package org.example.chapter09_pracice;

/*
    === 사용자(User) 관리시스템 구현 ===
    : 사용자 정보를 관리하는 시스템
    - 사용자 생성 및 수정
    - 생성 및 수정 시 생성일, 수정일을 기록 -> DateUtil 사용

    1) 요구사항
    User 클래스
    - 필드: id(사용자 고유 번호), name, email, createdAt, updatedAt
    - 생성자: createdAt 값 설정(+ 정보 수정 시 updatedAt 설정)
    - 메서드: toString() 메서드 오버라이딩해 사용자 정보를 출력할거임

    DateUtil '유틸 클래스' -> 일처리를 위한 클래스
    - 메서드: getCurrentDateTime() -> 현재 날짜 및 시간을 yyyy-MM-dd HH:mm:ss 형식으로 반환

    UserService 인터페이스
    - 사용자 추가, 조회(단건, 전체), 수정

    UserServiceImpl 클래스
    - ArrayList<User>을 사용해 사용자 목록을 관리
    - 존재하지 않는 id로 조회, 수정하는 경우 사용자 정의 예외 발생

    UserNotFoundException '예외 클래스'
    - 메시지를 받아 출력하는 사용자 정의 예외

    Main 클래스: 프로그램 실행의 진입점
    - UserServiceImpl를 인스턴스화 하여 동작을 실행

 */

// model
//: 정보(데이터)를 담는 틀
// 만약 학생 정보를 저장 시 -> Student 클래스 모델이 있고, 해당 모델 내에 이름, 나이, 학번 등이 포함됨

//service
// : 일을 처리하는 곳
// 학생 등록, 학생 정보 가져오기, 학생 삭제하기 등을 처리 >> model로 일처리함

import org.example.chapter09_pracice.exception.UserNotFoundException;
import org.example.chapter09_pracice.model.User;
import org.example.chapter09_pracice.service.UserService;
import org.example.chapter09_pracice.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 로직 구현 //\

        UserService userService = new UserServiceImpl();

        // 1. 사용자 추가
        userService.addUser(new User(1,"권민현", "qwer123@example.com"));
        userService.addUser(new User(2,"asdfa", "asdf123@example.com"));
        userService.addUser(new User(3,"ewerw", "werw123@example.com"));
        userService.addUser(new User(4,"zxcvz", "zxcv123@example.com"));

        // 2. 사용자 목록 추가
        List<User> users = userService.getAllUsers();
        for (User user: users) {
            System.out.println(user);
        }

        //3. 이메일 수정
        try {
            userService.updateUserEmail(1, "asdf123@example.com");
        }catch (UserNotFoundException e) {
            System.out.println("수정 실패: " + e.getMessage());
        }
        
        //4. 단건 회원조회(id)
        User user = userService.getUserById(1);
        System.out.println(user);

        //5. 존재하지 않는 사용자 검색(예외발생)
        try {
            userService.getUserById(100);
        }catch (UserNotFoundException e){
            System.out.println("조회실패: " + e.getMessage());
        }

        //6. 사용자 삭제
        try {
            User result = userService.getUserById(1);
            System.out.println(result);

            userService.deleteUser(1);
            System.out.println("사용자가 정상적으로 삭제되었습니다.");

            userService.getUserById(1); // 삭제 실패: 사용자 ID에 1값이 없습니다. (조회 실패)
        } catch(UserNotFoundException e) {
            System.out.println("삭제 실패: " + e.getMessage());
        }


        //특정이름 조회
        String searchName = "롸롸롸";
        List<User> filteredUsers = userService.findUserByname(searchName);

        System.out.println("\n[" + searchName + "] 이름으로 조회된 사용자 목록");
        for (User userData: filteredUsers) {
            System.out.println(userData);
        }
    }
}
